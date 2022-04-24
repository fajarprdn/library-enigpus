package com.enigma.enigpusboot.service;

import com.enigma.enigpusboot.entity.Book;
import com.enigma.enigpusboot.entity.Borrow;
import com.enigma.enigpusboot.exception.DataNotFoundException;
import com.enigma.enigpusboot.exception.MemberIsBlockedException;

import java.sql.Date;
import java.util.List;

public interface BorrowService {

    Borrow saveBorrow(String memberId, String bookId) throws MemberIsBlockedException;

    List<Borrow> searchBorrowByMemberId(String id) throws DataNotFoundException;

    Borrow searchBorrowById(String id);

}
