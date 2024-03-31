package com.group.libraryapp.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
//jparepository<user의 id부분>

public interface UserRepository extends JpaRepository<User, Long> {

    //findbyName으로 sql이 자동으로 조립됨.by를 기준으로 where절이 생성됨
    //find라고 작성하면 1개의 데이터만 가져옴
    //by 뒤의 내용으로 select query가 작성됨 select * from user where name = ?으로
    Optional<User> findByName(String name);
}
