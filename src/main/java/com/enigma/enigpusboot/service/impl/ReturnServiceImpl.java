package com.enigma.enigpusboot.service.impl;

import com.enigma.enigpusboot.entity.Borrow;
import com.enigma.enigpusboot.entity.Return;
import com.enigma.enigpusboot.repository.BookRepository;
import com.enigma.enigpusboot.repository.BorrowRepository;
import com.enigma.enigpusboot.repository.ReturnRepository;
import com.enigma.enigpusboot.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class ReturnServiceImpl implements ReturnService {
    @Autowired
    BorrowRepository borrowRepository;
    @Autowired
    BookRepository bookRepository;

    @Autowired
    ReturnRepository returnRepository;

    @Override
    public void bookReturn(String borrowId, Date returnDate) {
        Borrow borrow = borrowRepository.findById(borrowId).get();
        borrow.setStatus("INACTIVE");
        borrow.getBook().setStock(borrow.getBook().getStock()+1);

        Return returnBook = new Return();
        returnBook.setReturnDate(returnDate);
        returnRepository.save(returnBook);

    }
}
