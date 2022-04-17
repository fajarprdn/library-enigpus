package com.enigma.enigpusboot.controller;

import com.enigma.enigpusboot.constant.ApiUrlConstant;
import com.enigma.enigpusboot.dto.MemberSearchDTO;
import com.enigma.enigpusboot.entity.Member;
import com.enigma.enigpusboot.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiUrlConstant.MEMBER)
public class MemberController {

    @Autowired
    MemberService memberService;

    @PostMapping
    public Member createMember(@RequestBody Member member){
        return memberService.saveMember(member);
    }

//    @GetMapping
//    public List<Member> getAllMember(){
//        return memberService.getAllMember();
//    }

    @GetMapping
    public Page<Member> searchCustomerPerPage(@RequestBody MemberSearchDTO memberSearchDTO,
                                                @RequestParam(name = "page",defaultValue = "0") Integer page,
                                                @RequestParam(name = "size", defaultValue = "3") Integer sizePerPage){
        Pageable pageable = PageRequest.of(page,sizePerPage);
        return memberService.getMemberPerPage(memberSearchDTO, pageable);
    }

    @PutMapping
    public Member updateMember(@RequestBody Member member){
        return memberService.saveMember(member);
    }

    @DeleteMapping
    public void deleteMember(@RequestParam String id){
        memberService.deleteMember(id);
    }
}
