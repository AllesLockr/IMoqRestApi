package com.alleslocker.imoqrestapi.controller

import com.alleslocker.imoqrestapi.MockData
import com.alleslocker.imoqrestapi.model.Permission
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v2/permissions")
class PermissionController(private val dataStore: MockData) {
    @GetMapping
    fun getAllPermissions(): List<Permission> {
        return dataStore.permissions
    }
}