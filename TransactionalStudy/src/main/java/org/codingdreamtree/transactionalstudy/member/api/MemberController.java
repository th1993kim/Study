package org.codingdreamtree.transactionalstudy.member.api;

import lombok.RequiredArgsConstructor;
import org.codingdreamtree.transactionalstudy.member.application.MemberViewService;
import org.codingdreamtree.transactionalstudy.member.application.dto.ViewMember;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/members")
@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberViewService memberViewService;

    @GetMapping("/{seqMember}")
    public ResponseEntity<ViewMember> findMember(@PathVariable("seqMember") long seqMember) {
        return ResponseEntity.ok(memberViewService.findMember(seqMember));
    }
}
