package com.todolist.modules.task.entity

import com.todolist.modules.task.dto.DeadLineTask
import com.todolist.modules.task.dto.Task
import javax.persistence.*
import java.util.*

@Entity
@Table(name="dead_line_task")
class DeadLineTaskEntity : TaskEntity() {
    @Temporal(TemporalType.TIMESTAMP)
    var deadLine: Date? = null
    override fun toDto(): Task = run {
        val entity = this
        DeadLineTask().apply {
            user = entity.appUserEntity?.toDto()
            title = entity.title
            memo = entity.memo
            createdDate = entity.createdDate
            deadLine = entity.deadLine
        }
    }
}