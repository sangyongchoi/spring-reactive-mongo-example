package com.example.reactivemongo.repository

import com.example.reactivemongo.document.Demo
import reactor.core.publisher.Flux

interface DemoRepositoryCustom {

    suspend fun findBy(title: String): Flux<Demo>
}
