package com.psl.hd.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class ResourceNotFoundException {
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ApiError handleMethodNotAllowed(HttpRequestMethodNotSupportedException ex){
        StringBuilder builder = new StringBuilder();
        builder.append(ex.getMethod());
        builder.append(" Method is not supported for this request. Suppose the methods are ");
        ex.getSupportedHttpMethods().forEach(t->builder.append(t+ " "));
        ApiError apiError = new ApiError(HttpStatus.METHOD_NOT_ALLOWED, ex.getLocalizedMessage(), builder.toString());
        return apiError;
    }
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ApiError handleInternalServerError(Exception ex){
        ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage(),"An internal serve error occured");
        return apiError;
    }
}