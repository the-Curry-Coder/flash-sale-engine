package com.thecurrycoder.flashsaleengine.controller;

import com.thecurrycoder.flashsaleengine.dto.request.RegisterUser;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user" , produces = "application/json" )
@Tag(name = "User Login/Register APIs" , description = "User APis for Registration and login APIs")
@Slf4j
public class UserController {

    @PostMapping("/register")
    @Operation(summary = "Register Users " , description = "Used For Registring the Users")
    public ResponseEntity<?> registerUser(@RequestBody @Valid  RegisterUser registeruser)
    {


        return null; 
    }





}
