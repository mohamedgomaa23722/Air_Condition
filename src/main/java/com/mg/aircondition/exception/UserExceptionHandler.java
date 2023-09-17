package com.mg.aircondition.exception;

import com.mg.aircondition.dto.Error;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(value = CsException.class)
    public final ResponseEntity<Error> handleDuplicationEntryException(CsException e) {
        Error errorResponse = new Error()
                .code(e.exception.code)
                .message(e.exception.message)
                .desc(e.exception.desc);
        return ResponseEntity.status(e.exception.code).body(errorResponse);
    }

}
