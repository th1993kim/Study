package com.library.servletprojectapplication

import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "listServlet", urlPatterns = ["/servlet/list"])
class ListServlet : HttpServlet()  {

    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        resp?.contentType = "text/html; charset=UTF-8"
        val writer = resp?.writer

        val members = RegisterServlet.getMemberList()

        writer?.println("<!DOCTYPE html>")
        writer?.println("<html>")
        writer?.println("<head><meta charset='UTF-8'><title>Member List</title></head>")
        writer?.println("<body>")
        writer?.println("<h1>Member List (Servlet)</h1>")
        writer?.println("<ul>")
        for (m in members) {
            writer?.println("<li>" + m.name + " / " + m.password + "</li>")
        }
        writer?.println("</ul>")
        writer?.println("<a href='/servlet/registerform'>Go to Register Form</a>")
        writer?.println("</body>")
        writer?.println("</html>")
    }
}
