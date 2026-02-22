package com.library.servletprojectapplication.controller

import com.library.servletprojectapplication.model.Member
import com.library.servletprojectapplication.model.MemberRepository
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

class MemberSaveController : Controller {

    private val memberRepository : MemberRepository = MemberRepository()

    override fun process(request: HttpServletRequest, response: HttpServletResponse): String {

        request.setCharacterEncoding("UTF-8")
        val username = request.getParameter("username")
        val password = request.getParameter("password")

        val member = Member(username = username, password = password)
        memberRepository.save(member)

        request.setAttribute("member", member)

        return "/WEB-INF/views/result.jsp"
    }
}