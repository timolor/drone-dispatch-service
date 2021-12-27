package com.musalasoft.dispatchservice.api.advice;

import java.util.List;
import java.util.stream.Collectors;

import com.musalasoft.dispatchservice.exception.MusalaBadRequestException;
import com.musalasoft.dispatchservice.exception.MusalaResourceNotFoundException;
import com.musalasoft.dispatchservice.model.response.Response;
import com.musalasoft.dispatchservice.model.response.ResponseCodes;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class ApiAdvice {

    @ExceptionHandler(MusalaResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Response<?> handleResourceNotFoundException(MusalaResourceNotFoundException ex) {
        Response<?> response = new Response<>();
        response.setCode(ex.getCode());
        response.setMessage(ex.getMessage());
        return response;
    }

    @ExceptionHandler(MusalaBadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response<?> handleBadRequestException(MusalaBadRequestException ex) {
        Response<?> response = new Response<>();
        response.setCode(ex.getCode());
        response.setMessage(ex.getMessage());
        return response;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected Response<?> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        Response<List<String>> response = new Response<>();
        response.setCode(ResponseCodes.BAD_REQUEST.getCode());
        response.setMessage(ResponseCodes.BAD_REQUEST.getMessage());
        response.setData(fieldErrors.stream().map(x -> x.getDefaultMessage()).collect(Collectors.toList()));
        return response;
    }
}
