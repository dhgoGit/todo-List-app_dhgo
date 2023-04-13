package com.example.todolistproject.modules.task.dto

import com.example.todolistproject.user.AppUser
import java.util.Date

//interface for class have fields of 'title','memo','createdDate','user'

interface Task {
   var title:String?
   var memo:String?
   var createdDate:Date?
   val user:AppUser?
}