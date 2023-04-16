package com.todolist.apiperf.config

import com.todolist.apiperf.logmanager.ApiLogManager
import com.todolist.apiperf.interceptor.ApiLogInterceptor
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope
import org.springframework.context.annotation.ScopedProxyMode
import org.springframework.web.context.WebApplicationContext.SCOPE_REQUEST
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class ApiLogConfig : WebMvcConfigurer{
    @Bean
    @Scope(value = SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
    fun apiLogManager(request:HttpServletRequest?,response:HttpServletResponse?): ApiLogManager {
        return ApiLogManager(request,response)
    }

    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(ApiLogInterceptor())
    }

}