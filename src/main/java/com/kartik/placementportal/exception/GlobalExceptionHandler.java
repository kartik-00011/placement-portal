package com.kartik.placementportal.exception;

import com.kartik.placementportal.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.kartik.placementportal.dto.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ApiResponse<Object>> handleStudentNotFound(StudentNotFoundException ex) {

        System.out.println(">>> GLOBAL HANDLER CALLED <<<");

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ApiResponse<>(false,ex.getMessage(),null)
                );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleAnyException(Exception ex) {

        // Ignore H2 console errors
        if (ex.getClass().getName().contains("NoResourceFoundException")) {
            throw new RuntimeException(ex);
        }

        System.out.println(">>> ACTUAL ERROR TYPE: " + ex.getClass().getName());
        ex.printStackTrace();

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse(ex.getMessage(), 500));
    }

}
