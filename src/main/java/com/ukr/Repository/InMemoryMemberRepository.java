package com.ukr.Repository;

import com.ukr.Model.Member;

import java.util.ArrayList;
import java.util.List;

public class InMemoryMemberRepository implements MemberRepository{

    private List<Member> members = new ArrayList<>();

    @Override
    public void save(Member member) {
        members.add(member);
    }

    @Override
    public Member findByMemberId(String memberId) {
        return members.stream().filter(member -> member.getMemberId().equals(memberId)).findFirst().orElse(null);
    }

    @Override
    public List<Member> findAllMembers() {
        return members;
    }
}
