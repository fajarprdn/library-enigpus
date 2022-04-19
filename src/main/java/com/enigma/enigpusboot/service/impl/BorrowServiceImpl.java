package com.enigma.enigpusboot.service.impl;

import com.enigma.enigpusboot.constant.ResponseMessage;
import com.enigma.enigpusboot.entity.Book;
import com.enigma.enigpusboot.entity.Borrow;
import com.enigma.enigpusboot.entity.Member;
import com.enigma.enigpusboot.exception.DataNotFoundException;
import com.enigma.enigpusboot.exception.InsufficientStockException;
import com.enigma.enigpusboot.repository.BookRepository;
import com.enigma.enigpusboot.repository.BorrowRepository;
import com.enigma.enigpusboot.repository.MemberRepository;
import com.enigma.enigpusboot.service.BookService;
import com.enigma.enigpusboot.service.BorrowService;
import com.enigma.enigpusboot.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService {
    @Autowired
    BookService bookService;
    @Autowired
    MemberService memberService;
    @Autowired
    BorrowRepository borrowRepository;

    @Override
    public Borrow saveBorrow(String userName, String bookId, Date borrowDate) {
        Member member = memberService.getMemberByUserName(userName);
        Book book = bookService.getBookById(bookId);

        if (book.getStock() > 0) {

            bookService.saveBook(book);
            Borrow borrow = new Borrow();
            borrow.setBook(book);
            borrow.setMember(member);
            borrow.setStatus("ACTIVE");
            borrow.setBorrowDate(borrowDate);
            return borrowRepository.save(borrow);
        } else{
            throw new InsufficientStockException(String.format(ResponseMessage.INSUFFICIENT_STOCK, book.getId()));
        }

    }

    @Override
    public List<Borrow> searchBorrowByUserName(String userName) throws DataNotFoundException {
//        Borrow borrow = borrowRepository.findBorrowByStatus()
        List<Borrow> borrowsActive = new ArrayList<>();
        Member member = memberService.getMemberByUserName(userName);
        for (Borrow b : member.getBorrows()) {
            if (b.getStatus().equals("ACTIVE")) {
                borrowsActive.add(b);
            }
        }

//        if (memberService.getMemberByUserName(userName) == null) {
//            throw new DataNotFoundException(ResponseMessage.BORROW_DATA_NOT_FOUND);
//
//
//        } else {
//            Member member = memberService.getMemberByUserName(userName);
//            for (Borrow b : member.getBorrows()) {
//                if (b.getStatus().equals("ACTIVE")) {
//                    borrowsActive.add(b);
//                }
//            }

//        }
        return borrowsActive;
    }
}
