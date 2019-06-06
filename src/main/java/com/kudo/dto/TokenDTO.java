package com.kudo.dto;

public class TokenDTO {

    private String access_token;

    private UserDTO userDTO;

    public TokenDTO() {
    }

    public TokenDTO(String access_token, UserDTO userDTO) {
        this.access_token = access_token;
        this.userDTO = userDTO;
    }

    public String getAccess_token() {
        return access_token;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }
}

