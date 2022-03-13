# spring-reactive-mongo-example

spring-boot-starter-data-mongodb-reactive 와 querydsl 을 함께 사용하는 예제 프로젝트입니다.

### ReactiveQuerydslPredicateExecutor

-------------

````kotlin
suspend fun get(title: String): List<Demo> {
    return demoRepository.findAll(demo.title.eq(title)).collectList().awaitSingle() ?: emptyList()
}
````
querydsl 과 함께 사용할 수 있는 Interface

위와같이 인자로 Predicate 를 넘길 수 있다.

### ReactiveMongoOperations

-------------
ReactiveMongoOperations 과 querydsl 을 조합하여 사용할 수 있다.

ReactiveMongoOperations 는 Query() 를 사용하여 쿼리를 실행해야 한다.

이떄 발생할 수 있는 문제점은 type-safe 하지 않다는점과 오타에 취약하다는 점이다.

QClass 와 함께 사용한다면 이러한 단점을 해결하면서 Query() 를 사용할 수 있다.

#### DemoRepositoryCustomImpl.kt
```kotlin
override suspend fun findBy(title: String): Flux<Demo> {
    val query = Query()

    query
        .addCriteria(eqTitle(title))
        .fields()
        .include(demo.title.asName())

    return operations.find(
        query,
        Demo::class.java,
    )
}

private fun eqTitle(title: String): CriteriaDefinition {
    return demo.title isEqualTo title
}
```

