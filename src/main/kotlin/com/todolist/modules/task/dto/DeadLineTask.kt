package com.todolist.modules.task.dto

import com.todolist.modules.exceptions.AppException
import com.todolist.modules.task.entity.DeadLineTaskEntity
import com.todolist.modules.task.entity.TaskEntity
import java.util.*

data class DeadLineTask
    (
    override var title: String? = null,
    override var memo: String? = null,
    override var createdDate: Date? = null,
    override var user: AppUser? = null,
    var deadLine: Date? = null
) : Task {
    fun validate() {
        //it's createdDate can't further than deadLine. and it's userId can't be lower than 0
        //all fields are not null
        if (title == null || memo == null || createdDate == null || user == null || deadLine == null) {
            AppException.NULL_FIELD_EXCEPTION.throwException()
        } else {
            if (createdDate!!.after(deadLine)) {
                AppException.CREATED_DATE_FURTHER_THAN_DEADLINE.throwException()
            }
            user!!.validate()
        }

    }

    override fun toEntiy(): TaskEntity = run {
        val dto = this
        DeadLineTaskEntity().apply {
            user = dto.user
            title = dto.title
            memo = dto.memo
            createdDate = dto.createdDate
            deadLine = dto.deadLine
        }
    }
}