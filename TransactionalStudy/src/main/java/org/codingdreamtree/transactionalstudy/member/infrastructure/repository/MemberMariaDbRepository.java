package org.codingdreamtree.transactionalstudy.member.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import org.codingdreamtree.transactionalstudy.member.domain.Member;
import org.codingdreamtree.transactionalstudy.member.infrastructure.repository.jpa.MemberJpaRepository;
import org.codingdreamtree.transactionalstudy.member.infrastructure.repository.mybatis.MemberMyBatisRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class MemberMariaDbRepository implements MemberRepository {

    private final MemberJpaRepository memberJpaRepository;
    private final MemberMyBatisRepository memberMyBatisRepository;

    @Override
    public Optional<Member> findById(long seqMember) {
        return memberJpaRepository.findById(seqMember);
    }

    @Override
    public Member findByIdUseMyBatis(long seqMember) {
        return memberMyBatisRepository.findById(seqMember);
    }

    @Override
    public Member save(Member member) {
        return memberJpaRepository.save(member);
    }

    @Override
    public List<Member> saveAll(List<Member> memberList) {
        memberJpaRepository.saveAll(memberList);
        return memberList;
    }
}
