package com.enigma.enigpusboot.service;

import com.enigma.enigpusboot.entity.Book;
import com.enigma.enigpusboot.entity.Borrow;

import java.sql.Date;
import java.util.List;

public interface BorrowService {
    void saveBorrow(String userName, String bookId, Date borrowDate);
    Borrow searchBorrowByUserName(String userName);
}
