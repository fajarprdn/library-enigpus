package com.enigma.enigpusboot.service;

import com.enigma.enigpusboot.dto.BookSearchDTO;
import com.enigma.enigpusboot.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {
    Book searchBookById(String id);
    Book saveBook(Book book);
    void deleteBook(String id);
    Page<Book> getBookPerPage(BookSearchDTO bookSearchDTO, Pageable pageable);


}
