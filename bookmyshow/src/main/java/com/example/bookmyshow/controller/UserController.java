package com.example.bookmyshow.controller;

import com.example.bookmyshow.dtos.SignupStatus;
import com.example.bookmyshow.dtos.UserSignInRequestDto;
import com.example.bookmyshow.dtos.UserSignupRequestDto;
import com.example.bookmyshow.dtos.UserSignupResponseDto;
import com.example.bookmyshow.exception.UserAlreadyPresentException;
import com.example.bookmyshow.exception.UserNotFoundException;
import com.example.bookmyshow.models.User;
import com.example.bookmyshow.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;
    public UserController(UserService userService) {this.userService = userService;}
    @PostMapping("/signup")
    public UserSignupResponseDto signUp(@RequestBody UserSignupRequestDto userSignupRequestDto) throws UserAlreadyPresentException {
        User user = new User();
        user.setUserName(userSignupRequestDto.getName());
        user.setPassword(userSignupRequestDto.getPassword());
        user.setEmail(userSignupRequestDto.getEmail());
        User signedUpUser = userService.signUp(user);
        return to(signedUpUser);
    }
    public Boolean signIn(@RequestBody UserSignInRequestDto userSignInRequestDto) throws UserNotFoundException {
        return userService.signIn(userSignInRequestDto.getEmail(), userSignInRequestDto.getPassword());
    }
    private UserSignupResponseDto to(User user){
        UserSignupResponseDto userSignupResponseDto = new UserSignupResponseDto();
        userSignupResponseDto.setEmail(user.getEmail());
        userSignupResponseDto.setSignupStatus(SignupStatus.Success);
        return userSignupResponseDto;
    }
}
