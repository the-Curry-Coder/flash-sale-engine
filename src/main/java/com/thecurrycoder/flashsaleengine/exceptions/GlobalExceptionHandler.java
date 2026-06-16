package com.thecurrycoder.flashsaleengine.exceptions;

import com.thecurrycoder.flashsaleengine.dto.generic.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private  static final String  INT_SERV_ERR = "Internal Server Error";

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleError(MethodArgumentNotValidException ex)
    {
        Map<String, String> errors = new HashMap<>();

        // Extract field names and their corresponding error messages
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        ErrorResponse errorResponse = new ErrorResponse("Validation Failed", errors);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RoleNotFound.class)
    public ResponseEntity<ErrorResponse> handleError(RoleNotFound ex)
    {
        Map<String, String> errors = new HashMap<>();

        // Extract field names and their corresponding error messages
      errors.put("message", "Role Not Found");

        ErrorResponse errorResponse = new ErrorResponse(INT_SERV_ERR, errors);
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    }

