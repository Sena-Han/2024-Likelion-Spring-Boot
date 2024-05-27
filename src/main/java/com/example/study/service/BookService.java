package com.example.study.service;

import com.example.study.entity.Book;
import com.example.study.model.AddBookInput;
import com.example.study.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public long addBook(AddBookInput input) {
        Book book = Book.builder()
                .name(input.getBookName())
                .price(String.valueOf(input.getBookPrice()))
                .build();
        Book saved = bookRepository.save(book);
        return saved.getId();
    }
}