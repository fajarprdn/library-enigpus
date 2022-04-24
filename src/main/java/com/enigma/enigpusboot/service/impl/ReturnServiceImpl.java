package com.enigma.enigpusboot.service.impl;

import com.enigma.enigpusboot.entity.Borrow;
import com.enigma.enigpusboot.entity.Return;
import com.enigma.enigpusboot.repository.BookRepository;
import com.enigma.enigpusboot.repository.BorrowRepository;
import com.enigma.enigpusboot.repository.ReturnRepository;
import com.enigma.enigpusboot.service.BookService;
import com.enigma.enigpusboot.service.BorrowService;
import com.enigma.enigpusboot.service.ReturnService;
import jdk.nashorn.api.scripting.NashornScriptEngineFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Service
public class ReturnServiceImpl implements ReturnService {
    @Autowired
    BorrowService borrowService;

    @Autowired
    BookService bookService;

    @Autowired
    ReturnRepository returnRepository;


    @Override
    public void bookReturn(String borrowId) {
        Borrow borrow = borrowService.searchBorrowById(borrowId);
        borrow.setStatus("INACTIVE");


        Return returnBook = new Return();
        returnBook.setBorrow(borrow);
        returnBook.setReturnDate(LocalDate.now());

        if(returnBook.getReturnDate().isAfter(borrow.getReturnDate())){
            Integer difference = returnBook.getReturnDate().compareTo(borrow.getReturnDate());
            System.out.println(difference);
            returnBook.setCharge(1000*difference);
        } else{
            returnBook.setCharge(0);
        }
        returnRepository.save(returnBook);

    }
}
