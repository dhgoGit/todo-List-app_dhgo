package com.example.todolistproject.modules.task.repo.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
data class AppUserEntity(
    @Id var id:Long,
    var username:String,
    var password:String,
    var email:String,
    var role:String
)