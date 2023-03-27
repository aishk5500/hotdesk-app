package com.psl.hd.exception;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@Data
@Getter
@Setter
public class ApiError  {
    private HttpStatus status;
    private String message;
    private String developerMessage;
    public ApiError(HttpStatus status, String message, String developerMessage){
        super();
        this.status=status;
        this.message=message;
        this.developerMessage= developerMessage;
    }
}
