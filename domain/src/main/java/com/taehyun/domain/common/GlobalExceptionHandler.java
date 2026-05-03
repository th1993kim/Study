package com.taehyun.domain.common;

import com.taehyun.domain.common.exception.ErrorResponse;
import com.taehyun.domain.product.application.exception.ProductNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleException(ProductNotFoundException e,
                                                         HttpServletRequest request) {

        log.warn("ProductNotFound Exception message: {}", e.getMessage(), e);
        return build(HttpStatus.NOT_FOUND, e.getMessage(), request.getRequestURI());
    }

    public ResponseEntity<ErrorResponse> build(HttpStatus status, String message, String path) {
        return ResponseEntity.status(status).body(new ErrorResponse(path, message));
    }
}
