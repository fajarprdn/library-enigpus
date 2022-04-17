package com.enigma.enigpusboot.service.impl;

import com.enigma.enigpusboot.entity.Book;
import com.enigma.enigpusboot.entity.Borrow;
import com.enigma.enigpusboot.entity.Member;
import com.enigma.enigpusboot.repository.BookRepository;
import com.enigma.enigpusboot.repository.BorrowRepository;
import com.enigma.enigpusboot.repository.MemberRepository;
import com.enigma.enigpusboot.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    BorrowRepository borrowRepository;

    @Override
    public void saveBorrow(String userName, String bookId, Date borrowDate) {
        Member member = memberRepository.findByUserName(userName);
        Book book = bookRepository.findById(bookId).get();

        if(book.getStock()>0){
            book.setStock(book.getStock()-1);
            bookRepository.save(book);

            Borrow borrow = new Borrow();
            borrow.setBook(book);
            borrow.setMember(member);
            borrow.setStatus("ACTIVE");
            borrow.setBorrowDate(borrowDate);
            borrowRepository.save(borrow);
        }

    }

    @Override
    public Borrow searchBorrowByUserName(String userName) {
        List<Borrow> borrows = new ArrayList<>();
//        Borrow borrow = borrowRepository.findBorrowByStatus()
        Member member = memberRepository.findByUserName(userName);

        if (((borrowRepository.findBorrowByMemberId(member.getId())) !=null)){
            borrows.add(borrowRepository.findBorrowByMemberId(member.getId()));
        }

        for (Borrow borrow : borrows){
            if ( borrow.getStatus() == "ACTIVE"){
                return borrow;
            }
        }
        return  null;
    }
}
