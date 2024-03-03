package com.group.libraryapp.service.user;

import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdatRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.repository.user.UserRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(UserCreateRequest request){
        userRepository.saveUser(request.getName(), request.getAge());
    }

    public List<UserResponse> getUsers(){
        return userRepository.getUsers();

    }
    //api가 updateUser를 직접받는게 아니고 컨트롤러에서 requestParm을 통해서 받은 것(객체로 변환한 ㅓ)을 받기 때문에 RequestParm을 안써도됨
    public void updateUser(UserUpdatRequest request){
        //        String readSql = "SELECT * FROM user WHERE id = ?";
//        boolean userIsNotExist = jdbcTemplate.query(readSql,(rs, rowNum) -> 0, request.getId()).isEmpty(); //getId()부분이 위의 ?부분임
//        //select의 반환이 있으면 0이  / 아무것도 없으면 빈 리스트가 반환됨
        if (userRepository.isUserNotExist(request.getId())){
            throw new IllegalArgumentException();
        }
       userRepository.updateUserName(request.getName(),request.getId());
    }

    public void deleteUser(String name) {
        if (userRepository.userIsNotExist(name)) {
            throw new IllegalArgumentException();
        }
        userRepository.deleteUser(name);
    }

}

