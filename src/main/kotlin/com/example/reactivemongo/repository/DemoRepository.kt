package com.example.reactivemongo.repository

import com.example.reactivemongo.document.Demo
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.data.querydsl.ReactiveQuerydslPredicateExecutor

interface DemoRepository : ReactiveMongoRepository<Demo, ObjectId>, ReactiveQuerydslPredicateExecutor<Demo>, DemoRepositoryCustom
