package com.horiienko.controller;

import com.horiienko.domain.Book;
import com.horiienko.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class BookRest {

    private BookService bookService;

    @Autowired
    public BookRest(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public ResponseEntity<Collection<Book>> findAll() {
        Collection<Book> bookList = bookService.findAll();
        HttpStatus status = getHttpStatus(bookList);
        return new ResponseEntity<>(bookList, status);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        Book book = bookService.findById(id);
        HttpStatus status = getHttpStatus(Collections.singleton(book));
        return new ResponseEntity<>(book, status);
    }

    @PostMapping(value = "/book")
    public ResponseEntity<Long> save(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.save(book), HttpStatus.CREATED);
    }

    @PutMapping("/book")
    public ResponseEntity<Long> update(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.update(book), HttpStatus.OK);
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) {
        Book book = bookService.findById(id);
        HttpStatus status = getHttpStatus(Collections.singleton(book));
        return new ResponseEntity<>(bookService.deleteById(id), status);
    }

    private HttpStatus getHttpStatus(Collection<Book> book) {
        return book.isEmpty()
                ? HttpStatus.NO_CONTENT
                : HttpStatus.OK;
    }
}
