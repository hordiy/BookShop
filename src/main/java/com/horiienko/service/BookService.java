package com.horiienko.service;

import com.horiienko.domain.Book;

import java.util.Collection;

public interface BookService {

    Collection<Book> findAll();

    Book findById(Long id);

    Long save(Book book);

    Long update(Book book);

    Long deleteById(Long id);
}
