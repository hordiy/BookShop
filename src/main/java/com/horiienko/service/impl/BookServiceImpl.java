package com.horiienko.service.impl;

import com.horiienko.domain.Book;
import com.horiienko.service.BookService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private Long bookId = 10L;
    private Map<Long, Book> bookMap = new HashMap<>();

    {
        Book book = new Book();
        book.setId(bookId);
        book.setTitle("Spring Microservice in Action");
        book.setAuthor("John Carnell");
        book.setCoverPhotoUrl("https://www.google.com/imgres?imgurl=https%3A%2F%2Fcv02.twirpx.net%2F2524%2F2524135.jpg%3Ft%3D20180509041900&imgrefurl=https%3A%2F%2Fwww.twirpx.com%2Ffile%2F2524135%2F&tbnid=MONlSEWEgdSQ-M&vet=12ahUKEwil5-Kb5pLqAhUKf5oKHTbLAKMQMygWegUIARC9AQ..i&docid=NJexKQrSwYVP6M&w=300&h=376&q=spring%20microservices&ved=2ahUKEwil5-Kb5pLqAhUKf5oKHTbLAKMQMygWegUIARC9AQ");
        book.setIsbnNumber(1617293989L);
        book.setPrice(BigDecimal.valueOf(2776.00));
        book.setLanguage("English");
        bookMap.put(book.getId(), book);

    }

    @Override
    public Collection<Book> findAll() {
        return bookMap.values();
    }

    @Override
    public Book findById(Long id) {
        return bookMap.get(id);
    }

    @Override
    public Long save(Book book) {
        Long newBookId = ++bookId;
        book.setId(newBookId);
        bookMap.put(book.getId(), book);
        return newBookId;
    }

    @Override
    public Long update(Book book) {
        bookId = book.getId();
        Optional
                .ofNullable(bookMap.get(bookId))
                .map(Book::getId)
                .ifPresent(id -> bookMap.put(id, book));

        return bookId;
    }

    @Override
    public Long deleteById(Long id) {
        Optional
                .ofNullable(bookMap.get(id))
                .ifPresent(book -> bookMap.remove(book.getId()));
        return id;
    }
}
