package com.group.libraryapp.dto.user.request;

public class UserCreateRequest {

    private String name;
    private Integer age; //int는 null을 표햔할 수 없음. 현재는 나이를 선택사항으로 놓을거기 때문에 Integer로 해야함

    public String getName(){
        return name;
    }
    public Integer getAge(){
        return age;
    }
}

