package com.todolist.modules.task.entity

import com.todolist.modules.task.dto.Task
import com.todolist.modules.user.entity.AppUserEntity
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.MappedSuperclass
import javax.persistence.Table
import java.util.*


//TaskEntity class. this class is for database table. and it would be used for database CRUD of Task
@MappedSuperclass
@Table(name="task")
abstract class TaskEntity{
    @Id var id:Long?=null
    var title:String?=null
    var memo:String?=null
    var createdDate: Date?=null
    @ManyToOne
    @JoinColumn(name ="user_id")
    var appUserEntity: AppUserEntity?=null
    abstract fun toDto(): Task
}