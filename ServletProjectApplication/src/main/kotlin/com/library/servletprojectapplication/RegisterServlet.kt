package com.library.servletprojectapplication

import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "registerServlet", urlPatterns = ["/servlet/register"])
class RegisterServlet : HttpServlet()  {


    companion object {
        private val memberList = mutableListOf<Member>();

        fun getMemberList(): List<Member> = memberList
    }

    override fun doPost(req: HttpServletRequest?, resp: HttpServletResponse?) {

        val username = req?.getParameter("username")
        val password = req?.getParameter("password")

        memberList.add(Member(name = username, password = password))
        resp?.sendRedirect("/servlet/list")
    }


}