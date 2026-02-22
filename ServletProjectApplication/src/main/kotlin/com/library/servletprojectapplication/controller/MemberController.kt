package com.library.servletprojectapplication.controller

import com.library.servletprojectapplication.model.Member
import com.library.servletprojectapplication.model.MemberRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/front-controller")
class MemberController (
    private val memberRepository: MemberRepository
) {

    @GetMapping("/members/save-form")
    fun showForm() : String {
        return "form";
    }

    @PostMapping("/members/save")
    fun save(member : Member, model : Model) : String {
        memberRepository.save(member)
        model.addAttribute("member", member)
        return "result";
    }

    @GetMapping("/members/list")
    fun list(model : Model) : String {
        val members = memberRepository.findAll()
        model.addAttribute("members", members)
        return "list";
    }

}