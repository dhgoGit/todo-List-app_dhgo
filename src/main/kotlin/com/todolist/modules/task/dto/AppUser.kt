package com.todolist.modules.task.dto

import com.todolist.modules.exceptions.AppException

data class AppUser
    (
    var id: Long?,
    var name: String?,
    var email: String?,
    var password: String?,
) {
    fun validate() {
        try {

            validateId()
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

    private fun validateId() {
        if (id!! < 0) {
            AppException.USER_ID_LOWER_THAN_ZERO.throwException()
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
}