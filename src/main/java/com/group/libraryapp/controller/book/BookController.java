package com.group.libraryapp.controller.book;

import com.group.libraryapp.dto.book.request.BookCreateRequest;
import com.group.libraryapp.dto.book.request.BookLoanRequest;
import com.group.libraryapp.service.book.BookService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    private final BookService bookService;
//생성자를 만들어서 스프링빈을 주입받음. 그러면 repository부분을 바꾸고 싶을 때, 알아서 바꿔줌
    //왜냐? 같은 스프링 빈에 service와 controller가 들어가 있기 때문에 알아서 바꿔줌.
    //그러니까  new xxservice이런거 안해줘도, annotation붙여주고 생성자 만들어주면됨

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/book")
    public void saveBook(@RequestBody BookCreateRequest request) {
        bookService.saveBook(request);
    }

    @PostMapping("/book/loan")
    public void loanBook(@RequestBody BookLoanRequest request ){
        bookService.loanBook(request);
    }
}
