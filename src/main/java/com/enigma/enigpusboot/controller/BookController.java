package com.enigma.enigpusboot.controller;

import com.enigma.enigpusboot.constant.ApiUrlConstant;
import com.enigma.enigpusboot.constant.ResponseMessage;
import com.enigma.enigpusboot.dto.BookSearchDTO;
import com.enigma.enigpusboot.entity.Book;
import com.enigma.enigpusboot.entity.Member;
import com.enigma.enigpusboot.service.BookService;
import com.enigma.enigpusboot.utils.PageResponseWrapper;
import com.enigma.enigpusboot.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiUrlConstant.BOOK)
public class BookController {

    @Autowired
    BookService bookService;


    @PostMapping
    public ResponseEntity<Response<Book>> createBook(@RequestBody Book book) {
        Response<Book> response = new Response<>();
        String message = String.format(ResponseMessage.DATA_INSERTED,"book");
        response.setMessage(message);
        response.setData(bookService.saveBook(book));
        return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body(response);
    }

    @GetMapping
    public PageResponseWrapper<Book> searchBookPerPage(@RequestBody BookSearchDTO bookSearchDTO,
                                                       @RequestParam(name = "page", defaultValue = "0") Integer page,
                                                       @RequestParam(name = "size", defaultValue = "3") Integer sizePerPage){
        Pageable pageable = PageRequest.of(page,sizePerPage);
        Page<Book> bookpage = bookService.getBookPerPage(bookSearchDTO,pageable);
        return new PageResponseWrapper<>(bookpage);
    }

    @PutMapping
    public Book updateBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @DeleteMapping
    public void deleteBook(@RequestParam String id) {
        bookService.deleteBook(id);
    }

}
