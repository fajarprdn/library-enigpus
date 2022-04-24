package com.enigma.enigpusboot.service.impl;

import com.enigma.enigpusboot.constant.ResponseMessage;
import com.enigma.enigpusboot.entity.Book;
import com.enigma.enigpusboot.entity.Borrow;
import com.enigma.enigpusboot.entity.Member;
import com.enigma.enigpusboot.exception.DataNotFoundException;
import com.enigma.enigpusboot.exception.InsufficientStockException;
import com.enigma.enigpusboot.exception.MemberIsBlockedException;
import com.enigma.enigpusboot.repository.BorrowRepository;
import com.enigma.enigpusboot.service.BookService;
import com.enigma.enigpusboot.service.BorrowService;
import com.enigma.enigpusboot.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
    public Borrow saveBorrow(String memberId,String bookId) throws MemberIsBlockedException {

        Member member = memberService.searchMemberById(memberId);
        Book book = bookService.searchBookById(bookId);
        if(member.getIsBlock()){
            throw new MemberIsBlockedException(String.format(ResponseMessage.USER_IS_BLOCKED,memberId));
        };


        if (book.getStock() > 0) {

            bookService.saveBook(book);
            Borrow borrow = new Borrow();
            borrow.setBook(book);
            borrow.setMember(member);
            borrow.setStatus("ACTIVE");
            borrow.setBorrowDate(LocalDate.now());
            borrow.setReturnDate(LocalDate.now().plusDays(7));
            return borrowRepository.save(borrow);
        } else{
            throw new InsufficientStockException(String.format(ResponseMessage.INSUFFICIENT_STOCK, book.getId()));
        }

    }

    @Override
    public List<Borrow> searchBorrowByMemberId(String id) throws DataNotFoundException {
        List<Borrow> borrowsActive = new ArrayList<>();


        if (memberService.searchMemberById(id) == null) {
            throw new DataNotFoundException(ResponseMessage.BORROW_DATA_NOT_FOUND);
        }
        Member member = memberService.searchMemberById(id);
        for (Borrow b : member.getBorrows()) {
            if (b.getStatus().equals("ACTIVE")) {
                borrowsActive.add(b);
            }
        }

        return borrowsActive;
    }

    @Override
    public Borrow searchBorrowById(String id) {
        return borrowRepository.findById(id).get();
    }
}
