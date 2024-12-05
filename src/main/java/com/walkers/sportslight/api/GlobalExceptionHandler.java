package com.walkers.sportslight.api;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    public ApiResponse<Object> bindException(BindException e) {
        // 예외 로깅
        log.warn("BindException occurred: {}", e.getMessage(), e);

        return ApiResponse.of(
                HttpStatus.BAD_REQUEST,
                e.getBindingResult().getAllErrors().get(0).getDefaultMessage()
        );
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ApiResponse<Object> handleGeneralException(HttpServletRequest request, Exception e) {

        String path = request.getRequestURI();

        if (path.startsWith("/actuator/prometheus")) {
            // Prometheus 요청은 별도 처리 (필요하다면 로깅만 수행)
            log.warn("Prometheus request exception ignored: {}", e.getMessage());
            return null; // 예외 처리 생략
        }

        // 일반적인 예외 로깅
        log.error("Unhandled exception occurred: {}", e.getMessage(), e);

        return ApiResponse.error(
                HttpStatus.INTERNAL_SERVER_ERROR,
                e.getMessage()
        );
    }
}
