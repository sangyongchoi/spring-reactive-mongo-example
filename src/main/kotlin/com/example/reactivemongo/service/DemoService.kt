package com.example.reactivemongo.service

import com.example.reactivemongo.document.Demo
import com.example.reactivemongo.document.QDemo
import com.example.reactivemongo.repository.DemoRepository
import kotlinx.coroutines.reactor.awaitSingle
import org.springframework.stereotype.Service

@Service
class DemoService(
    private val demoRepository: DemoRepository,
) {

    private val demo = QDemo.demo

    suspend fun get(title: String): List<Demo>? {
        val findAll = demoRepository.findAll(demo.title.eq(title))

        return findAll.collectList().awaitSingle()
    }

    suspend fun create(title: String) {
        demoRepository.save(Demo(title = title)).subscribe()
    }
}
