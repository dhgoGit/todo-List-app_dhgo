package com.todolist.utils

import org.slf4j.Logger

class LogUtil {
    companion object{
        val log: KotlinLogger = KotlinLogger(
            org.slf4j.LoggerFactory.getLogger(LogUtil::class.java)
        )
        class KotlinLogger(private val logger: Logger){
            fun info(lambda:()->String){
                logger.info(lambda())
            }
        }
    }
}