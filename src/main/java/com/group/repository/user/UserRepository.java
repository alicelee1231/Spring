package com.group.repository.user;

import com.group.libraryapp.dto.user.response.UserResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;

    //생성자 만든 이유 : 객체로 jdbcTemplate을 중복으로 사용함. 그걸 없애고자 생성자로 만듦
    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean isUserNotExist( long id){
        String readSql = "SELECT * FROM user WHERE id = ?";
       return jdbcTemplate.query(readSql,(rs, rowNum) -> 0,id).isEmpty(); //getId()부분이 위의 ?부분임
    }

    public void updateUserName(String name, long id){
        String sql = "UPDATE user SET name = ? WHERE id = ?";
        jdbcTemplate.update(sql, name, id);
    }

    public boolean userIsNotExist(String name){
        String readSql = "SELECT * FROM user WHERE name = ?";
        return jdbcTemplate.query(readSql, (rs, rowNum) -> 0, name).isEmpty();
    }
    public void deleteUser(String name){
        String sql = "DELETE FROM user WHERE name = ?";
        jdbcTemplate.update(sql, name);
    }

    public void saveUser(String name, Integer age){
        String sql = "INSERT INTO user (name, age) VALUES(?,?)"; //입력에 따라 유동적으로 값을 처리해줘야하기 때문에 ??로 넣어야함.
        jdbcTemplate.update(sql,name,age);
    }

    public List<UserResponse> getUsers(){
        String sql = "SELECT * FROM user";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            long id = rs.getLong("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            return new UserResponse(id, name,age);
        });
    }
}
