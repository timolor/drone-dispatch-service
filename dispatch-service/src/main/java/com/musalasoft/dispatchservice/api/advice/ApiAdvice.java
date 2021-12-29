package com.musalasoft.dispatchservice.api.advice;

import java.util.List;
import java.util.stream.Collectors;

import com.musalasoft.dispatchservice.exception.MusalaBadRequestException;
import com.musalasoft.dispatchservice.exception.MusalaResourceNotFoundException;
import com.musalasoft.dispatchservice.model.response.Response;
import com.musalasoft.dispatchservice.model.response.ResponseCodes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javassist.NotFoundException;

@ControllerAdvice(annotations = RestController.class)
@ResponseBody
public class ApiAdvice {

    Logger logger = LoggerFactory.getLogger(ApiAdvice.class);

    @ExceptionHandler(MusalaResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Response<?> handleResourceNotFoundException(MusalaResourceNotFoundException ex) {
        Response<?> response = new Response<>();
        response.setCode(ResponseCodes.NOT_FOUND.getCode());
        response.setMessage(ex.getMessage());
        return response;
    }

    @ExceptionHandler(MusalaBadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response<?> handleBadRequestException(MusalaBadRequestException ex) {
        Response<?> response = new Response<>();
        response.setCode(ResponseCodes.BAD_REQUEST.getCode());
        response.setMessage(ex.getMessage());
        logger.error(ex.getMessage(), ex);
        return response;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Response<?> handleOtherExceptions(Exception ex) {
        Response<?> response = new Response<>();
        response.setCode(ResponseCodes.SYSYEM_ERROR.getCode());
        response.setMessage(ex.getMessage());
        logger.error(ex.getMessage(), ex);
        return response;
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Response<?> handleNotFoundException(NotFoundException ex) {
        Response<?> response = new Response<>();
        response.setCode(ResponseCodes.NOT_FOUND.getCode());
        response.setMessage(ex.getMessage());
        logger.error(ex.getMessage(), ex);
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
        logger.error(ex.getMessage(), ex);
        return response;
    }
}
