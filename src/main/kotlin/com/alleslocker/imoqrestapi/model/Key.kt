package com.alleslocker.imoqrestapi.model

data class Key(
    val id: String,
    val name: String,
    val belongsToPersonId: String?
)
