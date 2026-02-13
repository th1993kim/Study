package com.library.servletprojectapplication

import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "registerFormServlet", urlPatterns = ["/servlet/registerform"])
class RegisterFormServlet : HttpServlet()  {

    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        resp?.contentType = "text/html; charset=UTF-8"
        val writer = resp?.writer
        writer?.println("<!DOCTYPE html>");
        writer?.println("<html>");
        writer?.println("<head><meta charset='UTF-8'><title>Register Form</title></head>");
        writer?.println("<body>");
        writer?.println("<h1>Register Form (Servlet)</h1>");
        writer?.println("<form action='/servlet/register' method='post'>");
        writer?.println("Username: <input type='text' name='username'><br>");
        writer?.println("Password: <input type='password' name='password'><br>");
        writer?.println("<button type='submit'>Register</button>");
        writer?.println("</form>");
        writer?.println("</body>");
        writer?.println("</html>");
    }
}