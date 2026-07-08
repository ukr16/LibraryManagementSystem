package com.ukr.Repository;

import com.ukr.Model.Member;

import java.util.List;

public interface MemberRepository {
    void save(Member member);
    Member findByMemberId(String memberId);
    List<Member> findAllMembers();
}
