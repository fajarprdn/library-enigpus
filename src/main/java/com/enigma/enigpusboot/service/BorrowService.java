package com.enigma.enigpusboot.service;

import com.enigma.enigpusboot.entity.Book;
import com.enigma.enigpusboot.entity.Borrow;
import com.enigma.enigpusboot.exception.DataNotFoundException;

import java.sql.Date;
import java.util.List;

public interface BorrowService {
    Borrow saveBorrow(String userName, String bookId, Date borrowDate);
    List<Borrow> searchBorrowByUserName(String userName) throws DataNotFoundException;
}
