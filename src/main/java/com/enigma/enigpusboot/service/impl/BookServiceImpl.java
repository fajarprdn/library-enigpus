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
    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(String id) {
        if(bookRepository.findById(id).isPresent()){
            return bookRepository.findById(id).get();
        }else{
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

    @Override
    public Page<Book> getAllBookPerPage(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public List<Book> getBookByTitle(String title) {
        return null;
    }
}
