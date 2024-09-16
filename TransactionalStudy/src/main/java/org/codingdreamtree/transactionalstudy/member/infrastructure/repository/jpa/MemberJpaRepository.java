package org.codingdreamtree.transactionalstudy.member.infrastructure.repository.jpa;

import org.codingdreamtree.transactionalstudy.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {

}
