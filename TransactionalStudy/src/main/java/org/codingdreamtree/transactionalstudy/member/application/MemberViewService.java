package org.codingdreamtree.transactionalstudy.member.application;

import org.codingdreamtree.transactionalstudy.member.application.dto.ViewMember;

public interface MemberViewService {
    ViewMember findMember(long seqMember);
}
