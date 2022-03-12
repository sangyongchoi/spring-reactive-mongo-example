package com.example.reactivemongo.document

import com.querydsl.core.annotations.QueryEntity
import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.mapping.Document

@QueryEntity
@Document
data class Demo(
    val id: ObjectId? = null,
    val title: String,
)
