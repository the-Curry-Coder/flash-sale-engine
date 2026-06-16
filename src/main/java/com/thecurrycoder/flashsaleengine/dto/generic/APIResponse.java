package com.thecurrycoder.flashsaleengine.dto.generic;

import lombok.Data;

@Data
public class APIResponse<T> {
    private String message ;
    private Integer status;
    private T data;
}


