package com.todolist.apiperf.logmanager

import com.todolist.apiperf.interceptor.ApiLogInterceptor
import com.todolist.utils.LogUtil
import com.todolist.utils.LogUtil.Companion.KotlinLogger
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.springframework.web.util.ContentCachingResponseWrapper

class ApiLogManager(
    private val request: HttpServletRequest?,
    response:HttpServletResponse?
) {

    private val log: KotlinLogger? by lazy { LogUtil.getLogger(ApiLogInterceptor::class.java) } // 로거 가져오기
    private val cached: ContentCachingResponseWrapper?
    private var startTime: Long? = null
    init {
        cached = response?.let { ContentCachingResponseWrapper(it) } //response 캐싱
    }
    fun doTaskPreHandle() {
        startTime= log?.run {
            getTime()
        }
        log?.debug { "startTime : $startTime" }
    }
    fun doTaskPostHandle() {
        log?.info {
            """
                |duration : ${startTime?.let { getTime().minus(it) }} ms 
                |response size : ${cached?.contentSize}
                |""".trimMargin()
        }

        log?.debug {
            """
                |response : ${String(cached?.contentAsByteArray ?: ByteArray(0))}
            """.trimMargin()
        }
    }

    private fun getTime() = run {
        System.currentTimeMillis()
    }
}