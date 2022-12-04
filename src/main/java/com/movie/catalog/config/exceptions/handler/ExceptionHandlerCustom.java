package com.movie.catalog.config.exceptions.handler;

import com.movie.catalog.config.exceptions.handler.model.Problem;
import com.movie.catalog.config.exceptions.handler.model.ValidationProblem;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.stream.Collectors;

@ControllerAdvice
@RequiredArgsConstructor
public class ExceptionHandlerCustom extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
      var errorFields = ex.getFieldErrors();
      if(!errorFields.isEmpty()) {
        return super.handleExceptionInternal(ex, errorFields.stream().map(e -> ValidationProblem.builder().setField(e.getField()).setMessage(e.getDefaultMessage()).build())
          .collect(Collectors.toList()), headers, status, request);
      }
      var errorObjects = ex.getAllErrors();
      if(!errorObjects.isEmpty()) {
        return super.handleExceptionInternal(ex, errorObjects.stream().map(e -> ValidationProblem.builder().setField(e.getObjectName()).setMessage(e.getDefaultMessage()).build())
          .collect(Collectors.toList()), headers, status, request);
      }
      return super.handleExceptionInternal(ex, Problem.builder().setTitle("Um erro ocorreu durante a validação.").build(), headers, status, request);
    }

  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<Object> handleRuntime(RuntimeException ex, WebRequest request) {
    return super.handleExceptionInternal(ex, Problem.builder().setMessage(ex.getMessage()).build(), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
  }
}
