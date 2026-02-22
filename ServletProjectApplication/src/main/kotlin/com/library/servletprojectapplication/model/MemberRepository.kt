package com.library.servletprojectapplication.model

import org.springframework.stereotype.Repository

@Repository
class MemberRepository {

    companion object {
        private val store: MutableMap<String, Member> = mutableMapOf();
    }

    fun save(member: Member) {
        store.put(member.username, member)
    }

    fun findAll() : List<Member> {
        return store.values.toList()
    }
}