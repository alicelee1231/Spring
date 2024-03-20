package com.group.libraryapp.controller.user;

import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.service.user.UserServiceV2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //스프링 빈이 됨. 즉 jdbc에 의존하게됨
public class UserController {

    private final UserServiceV2 userService ;

    //@Quailifier("main")가 primary보다 더 앞선다.
    public UserController(UserServiceV2 userService){
        this.userService = userService;
    }

    @PostMapping("/user")
    public void saveUser(@RequestBody UserCreateRequest request){
       userService.saveUser(request);
    }

    @GetMapping("/user")
    public List<UserResponse> getUsers(){
    return userService.getUsers();
    }

     @PutMapping("/user")
     public void updateUser(@RequestBody UserUpdateRequest request){
        userService.updateUser(request);
    }

     @DeleteMapping("/user")
     public void deleteUser(@RequestParam String name) { //query를 직접 사용해서 포스트맨으로 찾음 그래서 requestbody가 아니라 param을 씀userService.deleteUser(name);
        userService.deleteUser(name );
    }


}
