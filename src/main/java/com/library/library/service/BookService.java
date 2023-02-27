package com.library.library.service;

import com.library.library.entity.Book;
import com.library.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Iterable<Book> getAll(){
        return bookRepository.findAll();
    }

    public Book addBook(Book book){
       return bookRepository.save(book);
    }
}
