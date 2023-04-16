package com.todolist.modules.task.dto

import com.todolist.modules.task.entity.TaskEntity
import com.todolist.modules.user.dto.AppUser
import java.util.Date

//interface for class have fields of 'title','memo','createdDate','user'

interface Task {
   var title:String?
   var memo:String?
   var createdDate:Date?
   val user: AppUser?

   fun toEntiy() : TaskEntity
}