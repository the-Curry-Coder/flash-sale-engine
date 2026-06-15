package com.thecurrycoder.flashsaleengine.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Address Of the user During Registration / Editing")
public class AddressDTO {

    @NotNull
    @Schema(description = "Flat / House Number " , requiredMode = Schema.RequiredMode.REQUIRED)
    private String addressLine1;

    
    private String addressLine2;

    @NotNull
    @Schema(description = "City Name Of the User" , requiredMode = Schema.RequiredMode.REQUIRED)
    private String city;

    @NotNull
    @Schema(description = "State if the User is Required " , requiredMode = Schema.RequiredMode.REQUIRED)
    private String state ;

    @NotNull
    @Schema(description = "Country Is Required" , requiredMode = Schema.RequiredMode.REQUIRED)
    private String country;
    @NotNull
    @Schema(description = "Zip Is Required" , requiredMode = Schema.RequiredMode.REQUIRED)
    private String zip;
}
