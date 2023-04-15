package com.todolist.utils

import org.slf4j.Logger

class LogUtil {
    companion object{
        val log: KotlinLogger = KotlinLogger(
            org.slf4j.LoggerFactory.getLogger(LogUtil::class.java)
        )
        fun getLogger(clazz:Class<*>) = run { KotlinLogger(org.slf4j.LoggerFactory.getLogger(clazz)) }
        class KotlinLogger(private val logger: Logger){
            fun info(lambda:()->String){
                if(logger.isInfoEnabled)
                logger.info(lambda())
            }
            fun debug(lambda:()->String){
                if(logger.isDebugEnabled)
                    logger.info(lambda())
            }
            fun error(lambda:()->String){
                if(logger.isErrorEnabled)
                    logger.info(lambda())
            }
            fun warn(lambda:()->String){
                if(logger.isWarnEnabled)
                    logger.info(lambda())
            }
        }
    }
}