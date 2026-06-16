package com.thecurrycoder.flashsaleengine.controller;

import com.thecurrycoder.flashsaleengine.dto.generic.APIResponse;
import com.thecurrycoder.flashsaleengine.dto.request.RegisterUser;
import com.thecurrycoder.flashsaleengine.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/user" , produces = "application/json" )
@Tag(name = "User Login/Register APIs" , description = "User APis for Registration and login APIs")
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    @Operation(summary = "Register Users " , description = "Used For Registering the Users")
    public ResponseEntity<?> registerUser(  @Valid @RequestBody RegisterUser registeruser)
    {

        log.info("Execution Started : UserController.registerUser()");

       Object  apiResponse = userService.registerUser(registeruser);


        log.info("Execution Ended : UserController.registerUser()");


        return null; 
    }





}
