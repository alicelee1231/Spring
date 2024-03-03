package com.group.libraryapp.service.book;

import com.group.repository.book.BookMemoryRepository;
import com.group.repository.book.BookMysqlRepository;
import com.group.repository.book.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void saveBook(){
        bookRepository.saveBook();
    }
}
