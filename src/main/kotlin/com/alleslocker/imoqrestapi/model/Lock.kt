package com.alleslocker.imoqrestapi.model

data class Lock(
    val id: String,
    val canBeOpenedByKeyId: Key
)