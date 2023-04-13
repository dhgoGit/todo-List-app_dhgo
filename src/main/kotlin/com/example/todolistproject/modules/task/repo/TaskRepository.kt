package com.example.todolistproject.modules.task.repo

import com.example.todolistproject.modules.task.dto.Task
import com.example.todolistproject.user.AppUser
import java.util.*

interface TaskRepository {
    fun save(task: Task): Task
    fun delete(task: Task)
    fun deleteAll()
    fun findAll(): List<Task>
    fun findById(id: Long): Task?
    fun findByTitle(title: String): Task?
    fun findByUser(user: AppUser): List<Task>
    fun findByCreatedDate(createdDate: Date): List<Task>
}