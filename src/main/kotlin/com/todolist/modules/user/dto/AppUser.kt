package com.todolist.modules.user.dto

import com.todolist.modules.exceptions.AppException
import com.todolist.modules.user.entity.AppUserEntity


data class AppUser
    (
    var name: String?=null,
    var email: String?=null,
    var password: String?=null,
) {
    fun validate() {
        try {
            validateName()
            validateEmail()
            validatePassword()

        } catch (e: AppException.Companion.DefinedException) {
            throw e
        } catch (e: Exception) {
            AppException.UNDEFINED_EXCEPTION.throwException()
        }
    }

    private fun validatePassword() {
        if (password!!.length < 3) {
            AppException.PASSWORD_FORMAT_EXCEPTION.throwException()
        }
    }
    private fun validateName() {
        if (name!!.length < 3) {
            AppException.NAME_FORMAT_EXCEPTION.throwException()
        }
    }

    private fun validateEmail() {
        var validationResult: Boolean = true

        if (!email!!.contains("@")) {
            validationResult = false
        }
        val emailParts = email!!.split("@")
        if (emailParts[0].isEmpty()) {
            validationResult = false
        }
        if (emailParts[1].isEmpty()) {
            validationResult = false
        }

        val localPart = emailParts[0]
        val localPartCharArray = localPart.toCharArray()
        for (char in localPartCharArray) {
            if (char.code < 33 || char.code > 126) {
                validationResult = false
            }
        }

        val domainPart = emailParts[1]
        if (domainPart.isEmpty() || domainPart.length > 254) {
            validationResult = false
        }

        if (!validationResult) {
            AppException.EMAIL_FORMAT_EXCEPTION.throwException()
        }

    }
    fun toEntity(): AppUserEntity {
        val dto = this
        return AppUserEntity().apply{
            this.username = dto.name
            this.email = dto.email
            this.password = dto.password
        }
    }
}