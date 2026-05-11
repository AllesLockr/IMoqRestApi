package com.alleslocker.imoqrestapi.controller

import com.alleslocker.imoqrestapi.MockData
import com.alleslocker.imoqrestapi.model.User
import org.springframework.web.bind.annotation.*

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
    fun createUser(@RequestBody user: User): User {
        dataStore.users.add(user)
        return user
    }

    @DeleteMapping("/{userId}")
    fun deleteUser(@PathVariable userId: Int) {
        dataStore.users.removeIf { it.id == userId }
    }
}