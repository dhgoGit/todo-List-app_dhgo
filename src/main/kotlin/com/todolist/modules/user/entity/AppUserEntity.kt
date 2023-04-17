package com.todolist.modules.user.entity

import com.todolist.modules.user.dto.AppUser
import javax.persistence.*
import lombok.Getter
import lombok.Setter
import javax.persistence.GenerationType
import javax.persistence.Table

@Entity
@Setter
@Getter
@Table(name="user")
class AppUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id") //현재는 index 대체
    var id: Long?=null
    @Column(name="user_name")
    var username: String?=null
    @Column(name="pw")
    var password: String?=null
    @Column(name="email")
    var email: String?=null

    fun toDto(): AppUser {
        return AppUser(
            name = username,
            password = password,
            email = email,
        )
    }
}