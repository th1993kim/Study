package org.codingdreamtree.transactionalstudy.member.infrastructure.repository.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.codingdreamtree.transactionalstudy.member.domain.Member;

@Mapper
public interface MemberMyBatisRepository {

    Member findById(@Param("seqMember") long seqMember);
}
