package com.group.libraryapp.service.user;

import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.domain.user.UserRepository;
import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceV2 {

    private final UserRepository userRepository;

    public UserServiceV2(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //save가 sql의 insert를 대신함, start transaction과 똑같음
    //함수에 문제 없으면 commit 아니면 rollback함
    @Transactional
    //transaction 적용, readonly는 select 쿼리만 사용할 때 사용, 성능적으로 이점이 있음
    public void saveUser(UserCreateRequest request) {
        User u = userRepository.save( new User(request.getName(), request.getAge()));
    }

    @Transactional(readOnly = true)
    public List<UserResponse> getUsers() {
        return userRepository.findAll().stream()
                .map(UserResponse::new)
                .collect(Collectors.toList());
    }//findall은 select * from 절과 동일

    @Transactional
    public void updateUser(UserUpdateRequest request){
        //select * from user where id = ?
        //findbyid : 한개의 id를 기준으로 데이터를 가져옴
        User user = userRepository.findById(request.getId())
                .orElseThrow(IllegalArgumentException::new);
        //user가 없다면 예와가 발생
        user.updateName(request.getName());
        //save를 하지 않아도 영속성 컨텍스트가 저장해줌
    }

    @Transactional
    public void deleteUser(String name){
        User user = userRepository.findByName(name).orElseThrow();
        userRepository.delete(user);
    }

}
