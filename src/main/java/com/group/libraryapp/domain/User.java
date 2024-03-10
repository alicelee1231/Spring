package com.group.libraryapp.domain;

import javax.persistence.*;

@Entity //기본 생성자가 꼭 필요
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // automatically generates primary key. mysql의 auto_increment와 매칭
    private Long id = null;

    @Column(nullable = false, length = 20) //column은 객체의 필드와 테이블의 필드를 매핑함
    private String name;
    private Integer age;

    protected User(){}

    public User(String name, Integer age){
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException(String.format("잘못된 name(%s)이 들어왔습니다.", name));
        }

        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public Integer getAge(){
        return age;
    }

    public Long getId() {
        return id;
    }

    public void updateName(String namre){
        this.name = name;
    }
}
