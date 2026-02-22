package com.library.servletprojectapplication.controller

import com.library.servletprojectapplication.model.MemberRepository
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

class MemberListController : Controller {

    private val memberRepository : MemberRepository = MemberRepository()

    override fun process(request: HttpServletRequest, response: HttpServletResponse): String {
        val memberList = memberRepository.findAll()
        request.setAttribute("members", memberList)
        return "/WEB-INF/jsp/list.jsp"
    }
}