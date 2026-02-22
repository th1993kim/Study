package com.library.servletprojectapplication.controller

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

interface Controller {
    fun process(request: HttpServletRequest, response: HttpServletResponse) : String
}