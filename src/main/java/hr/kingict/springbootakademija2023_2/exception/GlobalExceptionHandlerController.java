package hr.kingict.springbootakademija2023_2.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandlerController {

    @ExceptionHandler
    public ResponseEntity<List<String>> handleException(MethodArgumentNotValidException e){

        return ResponseEntity
                .badRequest()
                .body(e.getAllErrors()
                        .stream()
                        .map(ObjectError::toString)
                        .toList());

    }
}
