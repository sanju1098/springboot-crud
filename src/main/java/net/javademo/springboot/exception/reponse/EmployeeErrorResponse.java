package net.javademo.springboot.exception.reponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeErrorResponse {
    private String errorMessage;
    private int errorCode;
    private HttpStatus httpStatus;

}
