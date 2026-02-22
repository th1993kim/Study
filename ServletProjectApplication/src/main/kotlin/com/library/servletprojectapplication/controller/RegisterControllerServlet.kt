package com.library.servletprojectapplication.controller

import com.library.servletprojectapplication.model.Member
import com.library.servletprojectapplication.model.MemberRepository
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "registerControllerServlet", urlPatterns = ["/model2/register"])
class RegisterControllerServlet : HttpServlet() {

    companion object {
        private val memberRepository : MemberRepository = MemberRepository()
    }

    override fun doPost(req: HttpServletRequest, resp: HttpServletResponse) {

        req.setCharacterEncoding("UTF-8")
        val username = req.getParameter("username")
        val password = req.getParameter("password")

        memberRepository.save(Member(username = username, password = password))
        resp.sendRedirect(req.contextPath + "/model2/list")
    }
}