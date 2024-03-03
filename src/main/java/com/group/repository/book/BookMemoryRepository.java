package com.group.repository.book;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public class BookMemoryRepository implements BookRepository{

//    private final List<Book> books = new ArrayList<Book>();
    @Override
    public void saveBook(){
        System.out.println("here");

    }
}
