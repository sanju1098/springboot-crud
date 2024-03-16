package net.javademo.springboot.exception.handler;

import net.javademo.springboot.exception.EmailIdCannotBeNull;
import net.javademo.springboot.exception.InvalidEmailFormatException;
import net.javademo.springboot.exception.ResourceNotCreatedException;
import net.javademo.springboot.exception.ResourceNotFoundException;
import net.javademo.springboot.exception.reponse.EmployeeErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class EmployeeExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<EmployeeErrorResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex){

        EmployeeErrorResponse resourceNotFoundResponse =  EmployeeErrorResponse.
                builder().
                errorMessage(ex.getMessage()).
                errorCode(404).
                httpStatus(HttpStatus.NOT_FOUND).
                build();

        // resourceNotFoundResponse.setErrorMessage();
        // resourceNotFoundResponse.setErrorCode(404);

        return  ResponseEntity.ok(resourceNotFoundResponse);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ResourceNotCreatedException.class, EmailIdCannotBeNull.class, InvalidEmailFormatException.class})
    public ResponseEntity<EmployeeErrorResponse> resourceNotCreatedExceptionHandler(RuntimeException ex) {

        EmployeeErrorResponse resourceCreateErrorResponse = EmployeeErrorResponse.
                builder().
                errorMessage(ex.getMessage()).
                errorCode(400).
                httpStatus(HttpStatus.BAD_REQUEST).
                build();

        return new ResponseEntity<>(resourceCreateErrorResponse, HttpStatus.BAD_REQUEST);

    }
}
