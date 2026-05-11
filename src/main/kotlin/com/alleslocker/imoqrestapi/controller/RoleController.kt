package com.alleslocker.imoqrestapi.controller

import com.alleslocker.imoqrestapi.MockData
import com.alleslocker.imoqrestapi.dto.CreateRoleDTO
import com.alleslocker.imoqrestapi.dto.RoleDTO
import com.alleslocker.imoqrestapi.model.RoleDetails
import org.springframework.web.bind.annotation.*
import kotlin.random.Random

@RestController
@RequestMapping("api/v2/roles")
class RoleController(private val dataStore: MockData) {

    @GetMapping()
    fun getAllRoles(): List<RoleDTO> {
        return dataStore.roles.map { detail -> RoleDTO(detail.id, detail.name) }
    }

    @GetMapping("/{roleId}")
    fun getRoleDetails(@PathVariable roleId: Int): RoleDetails? {
        val role = dataStore.roles.find { it.id == roleId }
        if (role != null) {
            return role
        }
        return null
    }

    @PostMapping()
    fun createRole(@RequestBody createRoleDTO: CreateRoleDTO): RoleDTO {
        val permissions = createRoleDTO.permissionIds.mapNotNull { id ->
            dataStore.permissions.find { it.id == id }
        }
        val newRole = RoleDetails(id = Random.nextInt(), name = createRoleDTO.name, permissions = permissions)
        dataStore.roles.add(newRole)

        return RoleDTO(newRole.id, newRole.name)
    }

    @DeleteMapping("/{roleId}")
    fun deleteRole(@PathVariable roleId: Int): RoleDTO? {
        val role = dataStore.roles.find { it.id == roleId }
        if (role != null) {
            dataStore.roles.remove(role)
            return RoleDTO(id = role.id, name = role.name)
        }
        return null;
    }

}