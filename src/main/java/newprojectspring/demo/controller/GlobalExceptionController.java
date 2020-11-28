package newprojectspring.demo.controller;

import newprojectspring.demo.exception.WrongPageException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionController {


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(WrongPageException.class)
    public Error pageExceptionHandler(WrongPageException wrongPageException) {
        return new Error(wrongPageException.getMessage());
    }

}
