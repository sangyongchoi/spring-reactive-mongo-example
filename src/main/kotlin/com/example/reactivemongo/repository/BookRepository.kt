package com.example.reactivemongo.repository

import com.example.reactivemongo.document.Book
import org.springframework.data.mongodb.core.ReactiveMongoOperations
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.isEqualTo
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
class BookRepository(
    private val operations: ReactiveMongoOperations,
) {
    fun findBy(title: String): Flux<Book> {
        val query = Query()

        query.addCriteria(Book::title isEqualTo title)

        return operations.find(
            query,
            Book::class.java,
        )
    }
}
