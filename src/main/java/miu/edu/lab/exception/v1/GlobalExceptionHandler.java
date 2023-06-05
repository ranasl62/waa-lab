package miu.edu.lab.exception.v1;

import miu.edu.lab.domain.v1.ExceptionEntity;
import miu.edu.lab.response.Response;
import miu.edu.lab.service.v1.ExceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDate;
import java.time.LocalTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private ExceptionService exceptionService;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response<Void>> handleException(Exception exception) {

        try {
            ExceptionEntity exceptionEntity = new ExceptionEntity();
            exceptionEntity.setDate(LocalDate.now());
            exceptionEntity.setTime(LocalTime.now());
            exceptionEntity.setPrinciple("Faker");

            exceptionEntity.setExceptionType(exception.getClass().getName() + "@" + exception.getClass().getTypeName());
            exceptionEntity.setExceptionMessage(exception.getMessage());

            // Save the exception entity using the ExceptionService
            exceptionService.create(exceptionEntity);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getClass());
        }
        String errorMessage = "An error occurred: " + exception.getMessage();
        Response<Void> response = new Response<>(false, errorMessage, null);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}

