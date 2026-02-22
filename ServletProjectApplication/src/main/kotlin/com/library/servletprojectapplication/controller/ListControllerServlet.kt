package com.library.servletprojectapplication.controller

import com.library.servletprojectapplication.model.MemberRepository
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "listControllerServlet", urlPatterns = ["/model2/list"])
class ListControllerServlet : HttpServlet() {

    companion object {
        private val memberRepository : MemberRepository = MemberRepository()
    }

    override fun doGet(req: HttpServletRequest, resp: HttpServletResponse) {
        val memberList = memberRepository.findAll()
        req.setAttribute("members", memberList)
        val viewPath = "/WEB-INF/jsp/list.jsp"
        req.getRequestDispatcher(viewPath).forward(req, resp)
    }
}