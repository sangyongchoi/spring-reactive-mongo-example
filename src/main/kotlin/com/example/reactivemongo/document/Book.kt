package com.example.reactivemongo.document

import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Book(
    val id: ObjectId? = null,
    val title: String,
)
