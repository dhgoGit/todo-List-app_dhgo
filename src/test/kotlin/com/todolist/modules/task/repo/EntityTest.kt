package com.todolist.modules.task.repo

import com.todolist.modules.task.dto.AppUser
import com.todolist.modules.task.dto.DeadLineTask

import com.todolist.utils.LogUtil.Companion.log
import io.kotest.core.spec.style.FeatureSpec
import jakarta.persistence.EntityManager
import jakarta.persistence.Persistence

class EntityTest : FeatureSpec() {
    init {
        feature("엔티티 테스트") {
            scenario("타입변환 실험") {
                val deadLineTask = DeadLineTask("hello")
                log.info { "deadLineTask : ${deadLineTask.toEntiy()}" }
            }
            scenario("트랜잭션 실험") {

                AppUser(
                    name = "sig",
                    password = "1234",
                    email = "sig@sigimiyo.com",
                ).apply {
                    val entity = this.toEntity()
                    val em: EntityManager? =
                        Persistence
                            .createEntityManagerFactory("todo_list")
                            .run { createEntityManager() }
                    em?.transaction?.run {
                        try {
                            begin()
                            em.persist(entity)
                            commit()
                            log.info { "persist, commit" }
                        } catch (e: Exception) {
                            log.error { "Error: $e" }
                            rollback()
                            throw e
                        }
                    }
                }
            }
        }
    }
}