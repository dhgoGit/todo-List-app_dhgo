package com.todolist.modules.interceptor

import com.todolist.modules.apimeasure.ApiLogManager
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.ModelAndView

@Component
class ApiLogInterceptor() : HandlerInterceptor {

    @Autowired
    var apiLogManager: ApiLogManager? = null
    override fun preHandle(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any
    ) = run {
        apiLogManager?.doTaskPreHandle()
        super.preHandle(request, response, handler)
    }

    override fun postHandle(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any,
        modelAndView: ModelAndView?
    ) = run {
        apiLogManager?.doTaskPostHandle()
        super.postHandle(request, response, handler, modelAndView)
    }
}