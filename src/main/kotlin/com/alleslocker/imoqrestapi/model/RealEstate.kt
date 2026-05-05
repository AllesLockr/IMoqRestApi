package com.alleslocker.imoqrestapi.model

data class RealEstate(
    val id: String,
    val name: String,
    val zones: List<Zone>
)