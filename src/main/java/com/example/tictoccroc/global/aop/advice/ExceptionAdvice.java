package com.example.tictoccroc.global.aop.advice;


import com.example.tictoccroc.global.aop.domain.entity.ErrorLog;
import com.example.tictoccroc.global.aop.domain.repository.ErrorLogRepository;
import com.example.tictoccroc.global.common.dto.response.ResultResponse;
import com.example.tictoccroc.global.exception.AlreadyReservationException;
import com.example.tictoccroc.global.util.ResponseUtil;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

import static com.example.tictoccroc.global.common.enumeration.ResultCode.*;

@Transactional
@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionAdvice {

    private final ErrorLogRepository errorLogRepository;

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ResultResponse<ProblemDetail>> globalHandelException(final Exception exception) {
        ProblemDetail problemDetail = ProblemDetail
                .forStatusAndDetail(
                        SERVER_ERROR.getStatus(), SERVER_ERROR.getMessage());

        createErrorLog(exception, problemDetail);

        return ResponseUtil.error(problemDetail);
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<ResultResponse<ProblemDetail>> methodArgumentNotValidException(final MethodArgumentNotValidException exception) {
        ProblemDetail problemDetail = ProblemDetail
                .forStatusAndDetail(
                        VALUE_BAD_REQUEST.getStatus(),
                        Objects.requireNonNull(exception.getBindingResult().getAllErrors().get(0).getDefaultMessage()));

        createErrorLog(exception, problemDetail);

        return ResponseUtil.error(problemDetail);
    }

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<ResultResponse<ProblemDetail>> entityNotFoundException(final EntityNotFoundException exception) {
        ProblemDetail problemDetail = ProblemDetail
                .forStatusAndDetail(
                        VALUE_NOT_FOUND.getStatus(), VALUE_NOT_FOUND.getMessage());

        createErrorLog(exception, problemDetail);

        return ResponseUtil.error(problemDetail);
    }

    @ExceptionHandler({AlreadyReservationException.class})
    public ResponseEntity<ResultResponse<ProblemDetail>> alreadyReservationException(final AlreadyReservationException exception) {
        ProblemDetail problemDetail = ProblemDetail
                .forStatusAndDetail(
                        VALUE_NOT_FOUND.getStatus(), VALUE_NOT_FOUND.getMessage());

        createErrorLog(exception, problemDetail);

        return ResponseUtil.error(problemDetail);
    }

    private void createErrorLog(final Exception exception, final ProblemDetail problemDetail) {
        ErrorLog errorLog = ErrorLog
                .builder()
                .uri(String.valueOf(problemDetail.getInstance()))
                .message(exception.toString())
                .build();

        errorLogRepository.save(errorLog);

        exception.printStackTrace();
    }
}
