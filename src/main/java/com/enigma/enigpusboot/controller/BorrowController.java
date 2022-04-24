package com.enigma.enigpusboot.controller;

import com.enigma.enigpusboot.constant.ApiUrlConstant;
import com.enigma.enigpusboot.entity.Borrow;
import com.enigma.enigpusboot.entity.Member;
import com.enigma.enigpusboot.exception.DataNotFoundException;
import com.enigma.enigpusboot.exception.MemberIsBlockedException;
import com.enigma.enigpusboot.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping(ApiUrlConstant.BORROW)
public class BorrowController {
    @Autowired
    BorrowService borrowService;

    @PostMapping
    public Borrow saveBorrow(@RequestParam String memberId, @RequestParam String bookId) throws MemberIsBlockedException {
         return borrowService.saveBorrow(memberId, bookId);
    }

    @GetMapping
    public List<Borrow> searchBorrowByMemberId(@RequestParam String memberId) throws DataNotFoundException {
        return borrowService.searchBorrowByMemberId(memberId);
    }


}
