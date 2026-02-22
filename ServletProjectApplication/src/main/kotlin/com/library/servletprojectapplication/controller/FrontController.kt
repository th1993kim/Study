package com.library.servletprojectapplication.controller

import jakarta.servlet.ServletConfig
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse


//@WebServlet(name = "frontController", urlPatterns = ["/front-controller/*"])
class FrontController : HttpServlet() {

    companion object {
        private val controllerMap : MutableMap<String, Controller> = mutableMapOf()
    }

    override fun init(config: ServletConfig?) {
        controllerMap.put("/front-controller/members/save-form", MemberFormController())
        controllerMap.put("/front-controller/members/save", MemberSaveController())
        controllerMap.put("/front-controller/members/list", MemberListController())
    }

    override fun service(req: HttpServletRequest, resp: HttpServletResponse) {
        val requestURI = req.requestURI
        val controller = controllerMap[requestURI] ?: run {
            resp.status = HttpServletResponse.SC_NOT_FOUND
            return
        }
        val viewPath = controller.process(req, resp)
        req.getRequestDispatcher(viewPath).forward(req, resp)
    }
}