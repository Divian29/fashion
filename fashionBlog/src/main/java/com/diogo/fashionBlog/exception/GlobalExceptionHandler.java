package com.diogo.fashionBlog.exception;

import com.diogo.fashionBlog.error.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;



    @RestControllerAdvice

    public class GlobalExceptionHandler {

        @ExceptionHandler(DuplicateEmailException.class)
        public ResponseEntity<ErrorResponse> handleDuplicateEmailException(final DuplicateEmailException exception){
            ErrorResponse errorResponse = ErrorResponse.builder()
                    .message(exception.getMessage())
                    .status(HttpStatus.BAD_REQUEST)
                    .dateTime(LocalDateTime.now())
                    .debugMessage("Enter new Email or login.")
                    .build();
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler(PasswordMismatchException.class)
        public ResponseEntity<ErrorResponse> handlePasswordMismatchException(final PasswordMismatchException exception){
            ErrorResponse errorResponse = ErrorResponse.builder()
                    .message(exception.getMessage())
                    .status(HttpStatus.BAD_REQUEST)
                    .dateTime(LocalDateTime.now())
                    .debugMessage("Check password and try again.")
                    .build();
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler(WrongDetailsException.class)
        public ResponseEntity<ErrorResponse> handleWrongDetailsException(final WrongDetailsException exception){
            ErrorResponse errorResponse = ErrorResponse.builder()
                    .message(exception.getMessage())
                    .status(HttpStatus.BAD_REQUEST)
                    .dateTime(LocalDateTime.now())
                    .debugMessage("Check password and email try again.")
                    .build();
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }

