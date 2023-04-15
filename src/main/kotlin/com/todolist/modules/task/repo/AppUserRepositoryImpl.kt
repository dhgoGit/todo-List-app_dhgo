package com.todolist.modules.task.repo

import com.todolist.modules.task.dto.AppUser
import jakarta.persistence.EntityManager
import org.slf4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class AppUserRepositoryImpl : AppUserRepository {
    val logger: Logger = org.slf4j.LoggerFactory.getLogger(AppUserRepository::class.java)

    @Autowired
    private val em:EntityManager?=null
    override fun save(user: AppUser) {
        logger.info("hello new user!")
        em?.persist(user.toEntity())
    }
    override fun delete(user: AppUser) {
        TODO("Not yet implemented")
    }

    override fun deleteAll() {
        TODO("Not yet implemented")
    }

    override fun findAll(): List<AppUser> {
        TODO("Not yet implemented")
    }

    override fun findById(id: Long): AppUser? {
        TODO("Not yet implemented")
    }

    override fun findByUsername(username: String): AppUser? {
        TODO("Not yet implemented")
    }

    override fun findByEmail(email: String): AppUser? {
        TODO("Not yet implemented")
    }

}