package com.example.bookmyshow.service;

import com.example.bookmyshow.exception.UserAlreadyPresentException;
import com.example.bookmyshow.exception.UserNotFoundException;
import com.example.bookmyshow.models.User;
import com.example.bookmyshow.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }
    public User signUp(User user) throws UserAlreadyPresentException {
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        if(existingUser.isPresent())
        {
            throw new UserAlreadyPresentException("User already present "+ existingUser.get().getEmail());
        }
        User savedUser = new User();
        savedUser.setEmail(user.getEmail());
        savedUser.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        savedUser.setUserName(user.getUserName());
        return userRepository.save(savedUser);
    }
    public Boolean signIn(String email, String password) throws UserNotFoundException {
        Optional<User> existingUser = userRepository.findByEmail(email);
        if(existingUser.isEmpty())
        {
            throw new UserNotFoundException("User not found emailId : "+email);
        }
        User user = existingUser.get();
        if(!bCryptPasswordEncoder.matches(password, user.getPassword()))
        {
            throw new UserNotFoundException("Invalid password");
        }
        return true;
    }
}
