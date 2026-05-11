package com.alleslocker.imoqrestapi.model

data class User(
    val id: Int,
    val username: String,
    val firstName: String,
    val lastName: String,
    val roleIds: List<Int>
)
