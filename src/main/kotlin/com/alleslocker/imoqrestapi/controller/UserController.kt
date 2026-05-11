package com.alleslocker.imoqrestapi.controller

import com.alleslocker.imoqrestapi.MockData
import com.alleslocker.imoqrestapi.dto.CreateUserDTO
import com.alleslocker.imoqrestapi.model.User
import org.springframework.web.bind.annotation.*
import kotlin.random.Random

@RestController
@RequestMapping("api/v2/users")
class UserController(private val dataStore: MockData) {
    @GetMapping
    fun getAllUsers(roleIds: List<Int>): List<User> {
        return dataStore.users.filter { user ->
            user.roleIds.any { it in roleIds }
        }
    }

    @GetMapping("/{userId}")
    fun getUserById(@PathVariable userId: Int): User? {
        return dataStore.users.find { it.id == userId }
    }

    @PostMapping()
    fun createUser(@RequestBody user: CreateUserDTO): User {
        val newUser = User(
            id = Random.nextInt(),
            username = user.username,
            firstName = user.firstName,
            lastName = user.lastName,
            roleIds = user.roleIds,
        )
        dataStore.users.add(newUser)
        println("New user created: $newUser")
        return newUser
    }

    @DeleteMapping("/{userId}")
    fun deleteUser(@PathVariable userId: Int) {
        dataStore.users.removeIf { it.id == userId }
    }
}