package com.library.servletprojectapplication.controller

import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "registerFormControllerServlet", urlPatterns = ["/model2/registerform"])
class RegisterFormControllerServlet : HttpServlet() {

    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        val viewPath = "/WEB-INF/jsp/registerForm.jsp"
        req?.getRequestDispatcher(viewPath)?.forward(req, resp)
    }
}