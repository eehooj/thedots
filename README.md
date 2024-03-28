# 째깍섬 예약 프로젝트
> * Spring boot 3.2.4
> * Gradle
> * JAVA 17
> * JPA
> * H2
> * openapi
> * Test code (controller 만 작성)

## 패키지 구조
```
── tictoccroc
    ├── TictoccrocApplication.class
    ├── api
    │        ├── member
    │        │       └── domain
    │        │           ├── entity
    │        │           ├── repository
    │        │           └── service
    │        └── reservation
    │            ├── controller
    │            ├── domain
    │            │       ├── entity
    │            │       ├── repository
    │            │       │       └── custom
    │            │       └── service
    │            ├── dto
    │            │       ├── request
    │            │       └── response
    │            ├── enumertion
    │            └── service
    └── global
        ├── aop
        │        ├── advice
        │        └── domain
        │            ├── entity
        │            └── repository
        ├── common
        │        ├── dto
        │        │       └── response
        │        └── enumeration
        ├── config
        ├── exception
        ├── extension
        └── util
```

## 보완이 필요한 부분
> * 예약하기, 예약 취소 api에서 memberId를 보냈는데, 추후 spring security 사용하여 수정 필요
> * 수업, 매장의 코드 조회 api를 추가하여 프론트에서 코드 조회할 수 있도록 수정 필요