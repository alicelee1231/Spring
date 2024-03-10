package com.group.libraryapp.service.user;

import com.group.libraryapp.domain.User;
import com.group.libraryapp.domain.UserRepository;
import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdatRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceV2 {

    private final UserRepository userRepository;

    public UserServiceV2(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //save가 sql의 insert를 대신함
    public void saveUser(UserCreateRequest request) {
        User u = userRepository.save(new User(request.getName(), request.getAge()));
    }

    public List<UserResponse> getUsers() {
        return userRepository.findAll().stream()
                .map(UserResponse::new)
                .collect(Collectors.toList());
    }//findall은 select * from 절과 동일

    public void updateUser(UserUpdatRequest request){
        //select * from user where id = ?
        //findbyid : 한개의 id를 기준으로 데이터를 가져옴
        User user = userRepository.findById(request.getId())
                .orElseThrow(IllegalArgumentException::new);
        //user가 없다면 예와가 발생

        user.updateName(request.getName());
        userRepository.save(user);
    }

    public void deleteUser(String name){

        User user = userRepository.findByName(name);
        if(user == null){
            throw new IllegalArgumentException();
        }
        userRepository.delete(user);
    }

}
