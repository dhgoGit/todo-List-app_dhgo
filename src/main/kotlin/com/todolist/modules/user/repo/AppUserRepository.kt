package com.todolist.modules.user.repo

import com.todolist.modules.user.dto.AppUser

interface AppUserRepository {
    fun save(user: AppUser)
    fun delete(user: AppUser)
    fun deleteAll()
    fun findAll(): List<AppUser>
    fun findById(id: Long): AppUser?
    fun findByUsername(username: String): AppUser?
    fun findByEmail(email: String): AppUser?

}