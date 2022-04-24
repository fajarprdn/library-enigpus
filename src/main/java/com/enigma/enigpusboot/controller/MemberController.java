package com.enigma.enigpusboot.controller;

import com.enigma.enigpusboot.constant.ApiUrlConstant;
import com.enigma.enigpusboot.constant.ResponseMessage;
import com.enigma.enigpusboot.dto.MemberSearchDTO;
import com.enigma.enigpusboot.entity.Member;
import com.enigma.enigpusboot.service.MemberService;
import com.enigma.enigpusboot.utils.PageResponseWrapper;
import com.enigma.enigpusboot.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiUrlConstant.MEMBER)
public class MemberController {

    @Autowired
    MemberService memberService;


    @PostMapping
    public ResponseEntity<Response<Member>> createMember(@RequestBody Member member){
        Response<Member> response = new Response<>();
        String message = String.format(ResponseMessage.DATA_INSERTED,"member");
        response.setMessage(message);
        response.setData(memberService.saveMember(member));
        return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body(response);
    }


    @GetMapping
    public PageResponseWrapper<Member> searchCustomerPerPage(@RequestBody MemberSearchDTO memberSearchDTO,
                                                                      @RequestParam(name = "page",defaultValue = "0") Integer page,
                                                                      @RequestParam(name = "size", defaultValue = "3") Integer sizePerPage){
        Pageable pageable = PageRequest.of(page,sizePerPage);
        Page<Member> memberPage = memberService.getMemberPerPage(memberSearchDTO, pageable);
        return new PageResponseWrapper<>(memberPage);
    }

    @PutMapping
    public Member updateMember(@RequestBody Member member){
        return memberService.saveMember(member);
    }

    @PutMapping("/block")
    public void blockMember(@RequestParam String id){
         memberService.blockMemberById(id);
    }

    @PutMapping("/unblock")
    public void unblockMember(@RequestParam String id){
         memberService.unblockMemberById(id);
    }

    @DeleteMapping
    public void deleteMemberById(@RequestParam String id){
        memberService.deleteMemberById(id);
    }
}
