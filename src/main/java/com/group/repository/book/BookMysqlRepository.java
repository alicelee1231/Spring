package com.group.repository.book;


import org.springframework.stereotype.Repository;

@Repository
public class BookMysqlRepository implements BookRepository{
    @Override
    public void saveBook() {
        System.out.println("musql");
    }
}
