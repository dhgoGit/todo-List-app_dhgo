package com.example.todolistproject.modules.task.repo

import com.example.todolistproject.modules.task.dto.Task
import com.example.todolistproject.user.AppUser
import java.util.*

class TaskRepositoryImpl:TaskRepository {
    override fun save(task: Task): Task {
        TODO("Not yet implemented")
    }

    override fun delete(task: Task) {
        TODO("Not yet implemented")
    }

    override fun deleteAll() {
        TODO("Not yet implemented")
    }

    override fun findAll(): List<Task> {
        TODO("Not yet implemented")
    }

    override fun findById(id: Long): Task? {
        TODO("Not yet implemented")
    }

    override fun findByTitle(title: String): Task? {
        TODO("Not yet implemented")
    }

    override fun findByUser(user: AppUser): List<Task> {
        TODO("Not yet implemented")
    }

    override fun findByCreatedDate(createdDate: Date): List<Task> {
        TODO("Not yet implemented")
    }
}