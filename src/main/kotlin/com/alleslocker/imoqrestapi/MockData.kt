package com.alleslocker.imoqrestapi

import com.alleslocker.imoqrestapi.model.Permission
import com.alleslocker.imoqrestapi.model.RoleDetails
import com.alleslocker.imoqrestapi.model.User
import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Component

@Component
class MockData {

    lateinit var permissions: List<Permission>

    lateinit var roles: MutableList<RoleDetails>

    lateinit var users: MutableList<User>

    @PostConstruct
    fun init() {
        permissions = arrayListOf(
            Permission(1, "all"),
            Permission(2, "open-lock")
        )

        roles = arrayListOf(
            RoleDetails(
                id = 1,
                name = "admin",
                permissions = arrayListOf(permissions[0]),
            ),
            RoleDetails(
                id = 2,
                name = "person",
                permissions = arrayListOf(permissions[1])
            )
        )

        users = arrayListOf(
            User(
                id = 1,
                username = "bigAdmin",
                firstName = "Joe",
                lastName = "Mama",
                roleIds = listOf(1)
            ),
            User(
                id = 2,
                username = "schmidtJane",
                firstName = "Jane",
                lastName = "Schmidt",
                roleIds = listOf(2)
            ),
            User(
                id = 3,
                username = "soloHan",
                firstName = "Han",
                lastName = "Solo",
                roleIds = listOf(2)
            ),
            User(
                id = 4,
                username = "skywalkerAnakin",
                firstName = "Anakin",
                lastName = "Skywalker",
                roleIds = listOf(2)
            )
        )
    }
}