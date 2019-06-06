package com.kudo.service;

import com.kudo.dto.UserDTO;
import com.kudo.entity.User;
import com.kudo.repository.UserRepository;
import com.kudo.transformer.UserTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserTransformer userTransformer;

    @Autowired
    private UserRepository userRepository;

    public UserDTO registry(UserDTO userDTO) {
        User user = userTransformer.toEntity(userDTO);
        User result = userRepository.save(user);
        return userTransformer.toDto(result);
    }

    public UserDTO getUserByName(String name) {
        Optional<User> userOptional = userRepository.findByUsername(name);
        if (!userOptional.isPresent()) {
            return null;
        }
        return userTransformer.toDto(userOptional.get());
    }

    public UserDTO modifyUserInfo(String user_id, UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }
        Optional<User> optional = userRepository.findById(user_id);
        if (!optional.isPresent()) {
            return null;
        }
        User user = optional.get();
        user.modify(userTransformer.toEntity(userDTO));
        return userTransformer.toDto(userRepository.save(user));
    }

    public UserDTO modifyUserPassword(String user_id, String password) {
        Optional<User> optional = userRepository.findById(user_id);
        if (!optional.isPresent()) {
            return null;
        }
        User user = optional.get();
        user.modifyPassword(password);
        return userTransformer.toDto(userRepository.save(user));
    }

}

