package com.alleslocker.imoqrestapi.dto

data class CreateUserDTO(
    val username: String,
    val firstName: String,
    val lastName: String,
    val roleIds: List<Int>
)
