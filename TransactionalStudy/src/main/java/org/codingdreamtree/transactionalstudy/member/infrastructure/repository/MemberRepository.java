package org.codingdreamtree.transactionalstudy.member.infrastructure.repository;

import org.codingdreamtree.transactionalstudy.member.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Optional<Member> findById(long seqMember);

    Member findByIdUseMyBatis(long seqMember);

    Member save(Member member);

    List<Member> saveAll(List<Member> member);
}
