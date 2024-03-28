# 째깍섬 예약 프로젝트
> * Spring boot 3.2.4
> * Gradle
> * JAVA 17
> * JPA
> * H2
> * openapi
> * Test code (controller만 작성)

# 패키지 구조
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