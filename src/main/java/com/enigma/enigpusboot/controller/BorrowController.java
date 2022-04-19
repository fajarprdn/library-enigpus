package com.enigma.enigpusboot.controller;

import com.enigma.enigpusboot.constant.ApiUrlConstant;
import com.enigma.enigpusboot.entity.Borrow;
import com.enigma.enigpusboot.exception.DataNotFoundException;
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
    public void saveBorrow(@RequestBody String userName, String bookId, Date borrowDate){
         borrowService.saveBorrow(userName, bookId, borrowDate);
    }

    @GetMapping
    public List<Borrow> getBorrow(@RequestParam String userName) throws DataNotFoundException {
        return borrowService.searchBorrowByUserName(userName);
    }


}
