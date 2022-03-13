# spring-reactive-mongo-example

spring-boot-starter-data-mongodb-reactive 와 querydsl 을 함께 사용하는 예제 프로젝트입니다.

### ReactiveQuerydslPredicateExecutor
querydsl 과 함께 사용할 수 있는 Interface

인자로 Predicate 를 넘길 수 있다.
````kotlin
suspend fun get(title: String): List<Demo> {
    return demoRepository.findAll(demo.title.eq(title)).collectList().awaitSingle() ?: emptyList()
}
````
