package com.enigma.enigpusboot.service;

import com.enigma.enigpusboot.dto.MemberSearchDTO;
import com.enigma.enigpusboot.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MemberService {
    public List<Member> getAllMember();
    public Member getMemberById(String id);
    public Member saveMember(Member member);
    public void deleteMember(String id);
    Page<Member> getMemberPerPage(MemberSearchDTO memberSearchDTO, Pageable pageable);
}
