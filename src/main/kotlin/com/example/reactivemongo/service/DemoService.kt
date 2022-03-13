package com.example.reactivemongo.service

import com.example.reactivemongo.document.Demo
import com.example.reactivemongo.document.QDemo.demo
import com.example.reactivemongo.repository.DemoRepository
import kotlinx.coroutines.reactor.awaitSingle
import org.springframework.stereotype.Service

@Service
class DemoService(
    private val demoRepository: DemoRepository,
) {

    suspend fun get(title: String): List<Demo> {
        return demoRepository.findAll(demo.title.eq(title)).collectList().awaitSingle() ?: emptyList()
    }

    suspend fun create(title: String) {
        demoRepository.save(Demo(title = title)).subscribe()
    }
}
