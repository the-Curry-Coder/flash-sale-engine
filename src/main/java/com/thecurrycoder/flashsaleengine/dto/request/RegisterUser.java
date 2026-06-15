package com.thecurrycoder.flashsaleengine.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Request object for user registration")
public class RegisterUser {

    @NotNull
    @Schema ( description = "First Name Of the User " , requiredMode = Schema.RequiredMode.REQUIRED)
    private String firstName;

    @NotNull
    @Schema( description = "Last Name of the User ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String lastName ;

    @Email
    @Schema( description = "Email of the User" , requiredMode = Schema.RequiredMode.REQUIRED)
    private String email;


    @Schema( description = " Phone of the User" , requiredMode = Schema.RequiredMode.REQUIRED)
    private String phone;

    @Schema( description = "Address Of the User During Registration")
    private AddressDTO address;



}
