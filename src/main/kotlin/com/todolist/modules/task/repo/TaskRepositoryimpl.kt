package com.todolist.modules.task.repo

import com.todolist.modules.task.dto.Task
import com.todolist.modules.task.dto.AppUser
import jakarta.persistence.EntityManager
import org.slf4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class TaskRepositoryImpl: TaskRepository {
    val logger: Logger = org.slf4j.LoggerFactory.getLogger(TaskRepository::class.java)

    @Autowired
    var em:EntityManager?=null
    override fun save(task: Task){
        logger.info("hello new task!")
        em?.persist(task.toEntiy())
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