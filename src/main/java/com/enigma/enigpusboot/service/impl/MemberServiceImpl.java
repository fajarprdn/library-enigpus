package com.enigma.enigpusboot.service.impl;

import com.enigma.enigpusboot.dto.MemberSearchDTO;
import com.enigma.enigpusboot.entity.Member;
import com.enigma.enigpusboot.repository.MemberRepository;
import com.enigma.enigpusboot.service.MemberService;
import com.enigma.enigpusboot.specification.MemberSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    MemberRepository memberRepository;

    @Override
    public Member searchMemberById(String id) {
        if (memberRepository.searchMemberById(id)!= null){
            return memberRepository.searchMemberById(id);
        }
        return null;
    }

    @Override
    public Member getMemberByUserName(String userName) {
        if (!(memberRepository.findByUserName(userName)==null)){
            Member member = memberRepository.findByUserName(userName);
            return member;
        }
        return null;
    }

    @Override
    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Member updateMember(Member member) {
        return saveMember(member);
    }

    @Override
    public void deleteMemberById(String id) {
        memberRepository.deleteMemberById(id);
    }

    @Override
    public Page<Member> getMemberPerPage(MemberSearchDTO memberSearchDTO, Pageable pageable) {
        Specification<Member> memberSpecification = MemberSpecification.getMemberSpecification(memberSearchDTO);
        return memberRepository.findAll(memberSpecification, pageable);
    }

    @Override
    public void blockMemberById(String id) {
         memberRepository.blockMemberById(id);
    }

    @Override
    public void unblockMemberById(String id) {
        memberRepository.unblockMemberById(id);
    }
}
