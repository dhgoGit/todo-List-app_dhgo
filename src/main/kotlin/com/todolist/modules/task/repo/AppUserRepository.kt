package com.todolist.modules.task.repo

import com.todolist.modules.task.dto.AppUser
import com.todolist.modules.task.dto.Task
import java.util.*

interface AppUserRepository {
    fun save(user:AppUser)
    fun delete(user:AppUser)
    fun deleteAll()
    fun findAll(): List<AppUser>
    fun findById(id: Long): AppUser?
    fun findByUsername(username: String): AppUser?
    fun findByEmail(email: String): AppUser?

}