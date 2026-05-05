package com.alleslocker.imoqrestapi.model

data class Zone(
    val id: String,
    val realEstate: RealEstate,
    val locks: Set<Lock>,
)