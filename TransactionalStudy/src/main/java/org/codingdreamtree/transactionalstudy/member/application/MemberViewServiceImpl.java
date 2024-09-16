package org.codingdreamtree.transactionalstudy.member.application;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.codingdreamtree.transactionalstudy.member.application.dto.ViewMember;
import org.codingdreamtree.transactionalstudy.member.domain.Member;
import org.codingdreamtree.transactionalstudy.member.infrastructure.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class MemberViewServiceImpl implements MemberViewService {

    private final MemberRepository memberRepository;

    @PostConstruct
    @Transactional
    void init() {
        Member member = Member.builder()
                .name("t1")
                .age(10)
                .birthDay(LocalDate.of(1990, 1, 1))
                .build();

        Member member2 = Member.builder()
                .name("t2")
                .age(20)
                .birthDay(LocalDate.of(1993, 1, 1))
                .build();

        memberRepository.saveAll(List.of(member, member2));
    }

    @Override
    @Transactional(readOnly = true)
    public ViewMember findMember(long seqMember) {
        Optional<Member> member = memberRepository.findById(seqMember);
//        Member byIdUseMyBatis = memberRepository.findByIdUseMyBatis(seqMember);

//        return null;
        return member.map(ViewMember::of)
                .orElse(null);
    }


}
