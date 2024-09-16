package org.codingdreamtree.transactionalstudy.member.application.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.codingdreamtree.transactionalstudy.member.domain.Member;

import java.time.LocalDate;

@AllArgsConstructor
@Builder
@Getter
public class ViewMember {
    private String name;
    private int age;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDay;

    public static ViewMember of(Member member) {
        return ViewMember.builder()
        		.name(member.getName())
        		.age(member.getAge())
        		.birthDay(member.getBirthDay())
        		.build();
    }
}
