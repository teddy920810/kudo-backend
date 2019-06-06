package com.kudo.transformer;

import com.google.common.collect.Lists;
import com.kudo.dto.UserDTO;
import com.kudo.entity.User;
import org.springframework.stereotype.Component;


@Component
public class UserTransformer implements BaseTransformer<UserDTO, User> {

    @Override
    public UserDTO toDto(User user) {
        UserDTO userDTO = new UserDTO(user.getId(),
                user.getUsername(), user.getRole());
        return userDTO;
    }

    @Override
    public User toEntity(UserDTO userDTO) {

        User user = new User(userDTO.getUsername(), userDTO.getRole());
        return user;
    }
}

