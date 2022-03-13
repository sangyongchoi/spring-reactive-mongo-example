package com.example.reactivemongo.support

import com.querydsl.core.types.Path

import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.isEqualTo

infix fun <T> Path<T>.isEqualTo(value: T) = Criteria(this.asName()).isEqualTo(value)

fun Path<*>.asName(): String {
    val rootName = this.root.toString()
    val name = this.toString()

    if (rootName == name) {
        return name
    }

    // The reason add 1 is that exists "."
    return name.substring(rootName.length + 1)
}
