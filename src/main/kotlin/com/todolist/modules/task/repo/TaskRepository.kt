package com.todolist.modules.task.repo

import com.todolist.modules.task.dto.Task
import com.todolist.modules.task.dto.AppUser
import java.util.*


interface TaskRepository {
    fun save(task: Task)
    fun delete(task: Task)
    fun deleteAll()
    fun findAll(): List<Task>
    fun findById(id: Long): Task?
    fun findByTitle(title: String): Task?
    fun findByUser(user: AppUser): List<Task>
    fun findByCreatedDate(createdDate: Date): List<Task>
}