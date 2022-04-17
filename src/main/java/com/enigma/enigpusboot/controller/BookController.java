package com.enigma.enigpusboot.controller;

import com.enigma.enigpusboot.constant.ApiUrlConstant;
import com.enigma.enigpusboot.dto.BookSearchDTO;
import com.enigma.enigpusboot.entity.Book;
import com.enigma.enigpusboot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiUrlConstant.BOOK)
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

//    @GetMapping
//    public List<Book> getAllBook(){
//        return bookService.getAllBook();
//    }

//    @GetMapping
//    public Page<Book> getAllBookPerPage(@RequestParam(name = "page", defaultValue = "0") Integer page,
//                                            @RequestParam(name = "size", defaultValue = "3") Integer sizePerPage,
//                                            @RequestParam(name = "sortBy",defaultValue = "title") String sortByTitle,
//                                            @RequestParam(name = "direction",defaultValue = "asc") String direction) {
//        Sort sorting = Sort.by(Sort.Direction.fromString(direction),sortByTitle);
//        Pageable pageable = PageRequest.of(page, sizePerPage);
//        return bookService.getAllBookPerPage(pageable);
//    }

    @GetMapping
    public Page<Book> searchBookPerPage(@RequestBody BookSearchDTO bookSearchDTO,
                                     @RequestParam(name = "page", defaultValue = "0") Integer page,
                                     @RequestParam(name = "size", defaultValue = "3") Integer sizePerPage){
        Pageable pageable = PageRequest.of(page,sizePerPage);
        return bookService.getBookPerPage(bookSearchDTO,pageable);
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
