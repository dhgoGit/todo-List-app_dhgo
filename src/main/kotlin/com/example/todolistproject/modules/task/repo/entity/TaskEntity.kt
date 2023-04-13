package com.example.todolistproject.modules.task.repo.entity

import com.example.todolistproject.user.AppUser
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import java.util.*


//TaskEntity class. this class is for database table. and it would be used for database CRUD of Task
@Entity
data class TaskEntity(
    @Id var id:Long,
    var title:String,
    var memo:String,
    var createdDate: Date,
    @ManyToOne
    @JoinColumn(name ="user_id")
    var appUserEntity: AppUserEntity
)