package com.enigma.enigpusboot.service;

import com.enigma.enigpusboot.dto.MemberSearchDTO;
import com.enigma.enigpusboot.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MemberService {
    Member searchMemberById(String id);
    Member getMemberByUserName(String userName);
    Member saveMember(Member member);
    Member updateMember(Member member);
    void deleteMemberById(String id);
    Page<Member> getMemberPerPage(MemberSearchDTO memberSearchDTO, Pageable pageable);
    void blockMemberById(String id);
    void unblockMemberById(String id);
}
