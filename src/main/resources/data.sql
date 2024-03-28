insert into STORE values (1, '잠실점', '서울특별시 송파구 올림픽로 300 롯데월드몰 4층', now(), now()),
                         (2, '일산점', '경기 고양시 일산동구 중앙로 1205 지하 1층', now(), now()),
                         (3, '판교점', '경기도 성남시 수정구 창업로 18 2층', now(), now());

insert into LECTURE values (1, '도시농부', 1, now(), now()),
                           (2, '드로잉', 20, now(), now()),
                           (3, '오감놀이', 20, now(), now());

insert into MEMBER values (1, '부모1', 'parent1@aaaa.bbb', now(), now()),
                        (2, '부모2', 'parent2@aaaa.bbb', now(), now()),
                        (3, '부모3', 'parent3@aaaa.bbb', now(), now()),
                        (4, '부모4', 'parent3@aaaa.bbb', now(), now());

insert into STORE_LECTURE values (1, 1, 1, '2024-04-11 14:00:00', now(), now()),
                                 (2, 1, 3, '2024-04-10 16:00:00', now(), now()),
                                 (3, 2, 3, '2024-04-11 15:00:00', now(), now()),
                                 (4, 3, 2, '2024-04-10 14:00:00', now(), now()),
                                 (5, 1, 2, '2024-03-28 10:00:00', now(), now()),
                                 (6, 2, 3, '2024-03-27 11:00:00', now(), now()),
                                 (7, 3, 2, '2024-04-03 12:00:00', now(), now()),
                                 (8, 1, 2, '2024-04-08 13:00:00', now(), now()),
                                 (9, 1, 2, '2024-04-02 16:00:00', now(), now()),
                                 (10, 1, 2, '2024-04-29 14:00:00', now(), now());

insert into
    RESERVATION (insert_dt, member_id, reservation_dt, status, store_lecture_id, update_dt, id)
values
    (now(), 1, '2024-03-29 14:00:00', 'APPROVAL', 1, now(), default),
    (now(), 2, '2024-03-29 14:00:00', 'APPROVAL', 4, now(), default),
    (now(), 3, '2024-03-29 14:00:00', 'CANCEL', 4, now(), default),
    (now(), 4, '2024-03-29 14:00:00', 'APPROVAL', 4, now(), default);