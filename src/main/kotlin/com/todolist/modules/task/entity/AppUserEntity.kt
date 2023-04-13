package com.todolist.modules.task.entity

import com.todolist.modules.task.dto.AppUser
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class AppUserEntity {
    @Id
    var id: Long?=null
    var username: String?=null
    var password: String?=null
    var email: String?=null

    fun toDto(): AppUser {
        return AppUser(
            id = id,
            name = username,
            password = password,
            email = email,
        )
    }
}