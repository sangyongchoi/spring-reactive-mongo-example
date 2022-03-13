package com.example.reactivemongo.repository

import com.example.reactivemongo.document.Demo
import com.example.reactivemongo.document.QDemo.demo
import com.example.reactivemongo.support.asName
import com.example.reactivemongo.support.isEqualTo
import org.springframework.data.mongodb.core.ReactiveMongoOperations
import org.springframework.data.mongodb.core.query.CriteriaDefinition
import org.springframework.data.mongodb.core.query.Query
import reactor.core.publisher.Flux

class DemoRepositoryCustomImpl(
    private val operations: ReactiveMongoOperations,
) : DemoRepositoryCustom {

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
}
