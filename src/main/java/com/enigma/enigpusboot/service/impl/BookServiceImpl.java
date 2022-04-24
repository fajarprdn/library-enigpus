package com.enigma.enigpusboot.service.impl;

import com.enigma.enigpusboot.dto.BookSearchDTO;
import com.enigma.enigpusboot.entity.Book;
import com.enigma.enigpusboot.repository.BookRepository;
import com.enigma.enigpusboot.specification.BookSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements com.enigma.enigpusboot.service.BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public Book searchBookById(String id) {
        if (bookRepository.searchBookById(id)!=null){
            return bookRepository.searchBookById(id);
        }else {
            return null;
        }

    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(String id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Page<Book> getBookPerPage(BookSearchDTO bookSearchDTO, Pageable pageable) {
        Specification<Book> bookSpecification = BookSpecification.getBookSpecification(bookSearchDTO);
        return bookRepository.findAll(bookSpecification, pageable);
    }

}
