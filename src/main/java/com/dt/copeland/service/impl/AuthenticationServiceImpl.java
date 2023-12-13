package com.dt.copeland.service.impl;

import com.dt.copeland.dto.LoginDTO;
import com.dt.copeland.dto.RegisterDTO;
import com.dt.copeland.exception.LoginException;
import com.dt.copeland.exception.UserAlreadyExistException;
import com.dt.copeland.model.User;
import com.dt.copeland.repository.UserRepository;
import com.dt.copeland.service.AuthenticationService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;

    public AuthenticationServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public String register(RegisterDTO registerDTO) {

        if (userRepository.existsByUsername(registerDTO.getUsername())) {
            throw new UserAlreadyExistException(HttpStatus.BAD_REQUEST, "Username is already taken");
        }

        User user = new User();
        user.setName(registerDTO.getName());
        user.setUsername(registerDTO.getUsername());
        user.setPassword(registerDTO.getPassword());

        userRepository.save(user);

        return "User registration successful.";
    }

    @Override
    public Boolean login(LoginDTO loginDTO) {
        Optional<User> userOptional = userRepository.findByUsername(loginDTO.getUsername());

        User user;
        if(userOptional.isPresent()) {
            user = userOptional.get();
        }else {
            throw new LoginException("Username does not exist!");
        }

        return user.getPassword().equals(loginDTO.getPassword());
    }
}
