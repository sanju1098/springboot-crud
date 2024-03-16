package net.javademo.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND) // we can use in REST API also
// but instead of repeating every time we can add this is common place (this is file - Custom Exception File).
public class ResourceNotFoundException extends RuntimeException{
    public  ResourceNotFoundException(String message){
        super(message);
    }
}
