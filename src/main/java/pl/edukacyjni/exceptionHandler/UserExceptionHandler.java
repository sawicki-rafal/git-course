package pl.edukacyjni.exceptionHandler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleResponseStatusException(IllegalArgumentException ex) {
        return ResponseEntity.status(404).body(ex.getMessage());
    }
}
