package com.kudo.controller;

import com.google.common.base.Preconditions;
import com.kudo.dto.TokenDTO;
import com.kudo.dto.UserDTO;
import com.kudo.security.JWTConfigurer;
import com.kudo.security.TokenProvider;
import com.kudo.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider tokenProvider;

    @ApiOperation(value="注册", notes="用户注册、新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userDTO", value = "用户UserDTO", required = true, dataType = "UserDTO")
    })
    @PostMapping(value = "/regist")
    public ResponseEntity regist(@RequestBody UserDTO userDTO) throws Exception {
        checkUserDTO(userDTO);
        UserDTO user = userService.registry(userDTO);
        return ResponseEntity.ok(user);
    }

    @PostMapping(value = "/login")
    @ApiOperation(value = "/login", notes = "登陆")
    public ResponseEntity login(@RequestBody UserDTO userDTO) throws Exception {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userDTO.getUsername(), userDTO.getPassword());
        Authentication authentication = this.authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.createToken(authentication, false);
        return ResponseEntity.ok()
                .header(JWTConfigurer.AUTHORIZATION_HEADER, "Bearer " + jwt)
                .body(new TokenDTO(jwt, userService.getUserByName(userDTO.getUsername())));
    }

    @PostMapping(value = "/{user_id}")
    @ApiOperation(value = "/{user_id}", notes = "修改用户信息")
    public ResponseEntity modifyUserInfo(@PathVariable String user_id, @RequestBody UserDTO userDTO) {
        Preconditions.checkNotNull(user_id);
        Preconditions.checkNotNull(userDTO);
        UserDTO user = userService.modifyUserInfo(user_id, userDTO);
        return ResponseEntity.ok(user);
    }

    @PostMapping(value = "/password/{user_id}")
    @ApiOperation(value = "/{user_id}", notes = "修改用户密码")
    public ResponseEntity modifyUserPassword(@PathVariable String user_id, @RequestBody UserDTO userDTO) {
        Preconditions.checkNotNull(user_id);
        Preconditions.checkNotNull(userDTO);
        Preconditions.checkNotNull(userDTO.getPassword());
        UserDTO user = userService.modifyUserPassword(user_id, userDTO.getPassword());
        return ResponseEntity.ok(user);
    }

    private void checkUserDTO(UserDTO userDTO) {
        Preconditions.checkNotNull(userDTO, "registry can not be null.");
        String username = userDTO.getUsername();
        String password = userDTO.getPassword();
        Preconditions.checkNotNull(username, "username can not be null.");
        Preconditions.checkNotNull(password, "password can not be null.");

        Preconditions.checkArgument(username.length() > 4, "length of username must larger than 4");
        Preconditions.checkArgument(password.length() > 4, "length of password must larger than 4");
    }
}

