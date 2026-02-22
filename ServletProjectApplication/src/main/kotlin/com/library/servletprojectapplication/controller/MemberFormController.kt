package com.library.servletprojectapplication.controller

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

class MemberFormController : Controller {
    override fun process(request: HttpServletRequest, response: HttpServletResponse): String {
        return "/WEB-INF/views/form.jsp"
    }
}