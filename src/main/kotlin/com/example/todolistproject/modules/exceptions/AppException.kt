package com.example.todolistproject.modules.exceptions
enum class AppException(private val code:Int){

    CREATED_DATE_FURTHER_THAN_DEADLINE(1001),



    USER_ID_LOWER_THAN_ZERO(1002),
    EMAIL_FORMAT_EXCEPTION(1003),
    NAME_FORMAT_EXCEPTION(1004),
    PASSWORD_FORMAT_EXCEPTION(1005),





    NULL_FIELD_EXCEPTION(2000)
    ;





    fun throwException() {
        throw Exception("$code")
    }


}

