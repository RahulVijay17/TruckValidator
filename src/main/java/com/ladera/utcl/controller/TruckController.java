package com.ladera.utcl.controller;

import com.ladera.utcl.service.TruckService;
import com.ladera.utcl.vo.ErrorDetails;
import com.ladera.utcl.vo.TruckVo;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@RestControllerAdvice
public class TruckController extends ResponseEntityExceptionHandler {
    private TruckService truckService;

    @PostMapping
    public ResponseEntity<TruckVo> addTruck(@RequestBody @Valid TruckVo truckVo){

        return new ResponseEntity<>(truckService.addTruck(truckVo), HttpStatus.CREATED);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleGlobalException(Exception exception,
                                                WebRequest webRequest) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), webRequest.getDescription(false));

        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) ->{
            String fieldName = ((FieldError)error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        //return new ResponseEntity<>(errors, HttpStatus.NOT_ACCEPTABLE);

    }
}
