package miu.edu.lab.exception.v1;

import miu.edu.lab.dto.v1.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response<Void>> handleException(Exception exception) {
        String errorMessage = "An error occurred: " + exception.getMessage();
        Response<Void> response = new Response<>(false, errorMessage, null);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}

