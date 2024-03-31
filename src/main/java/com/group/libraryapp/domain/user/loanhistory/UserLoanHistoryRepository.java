package com.group.libraryapp.domain.user.loanhistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoanHistoryRepository extends JpaRepository<UserLoanHistory, Long> {

    //select * from user_loan_history where book_name =? and is_return = ?
    //위의 sql문과 아래가 동일함
    boolean existByBookNameAndIsReturn(String bookName, boolean isReturn);
}
