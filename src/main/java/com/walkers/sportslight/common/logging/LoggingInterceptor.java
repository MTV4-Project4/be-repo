package com.walkers.sportslight.common.logging;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


@Component
public class LoggingInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LoggingInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // 요청 시작 시간 설정
        request.setAttribute("startTime", System.currentTimeMillis());

        // 요청 로깅
        logger.info("Incoming request: {} {}", request.getMethod(), request.getRequestURI());
        return true;
    }

//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
//        // 핸들러 실행 후 로깅
//        if (handler instanceof HandlerMethod) {
//            HandlerMethod handlerMethod = (HandlerMethod) handler;
//            Class<?> handlerClass = handlerMethod.getBeanType();
//            Logger controllerLogger = LoggerFactory.getLogger(handlerClass);
//
//            controllerLogger.info("Handler executed: {}.{}",
//                    handlerClass.getSimpleName(), handlerMethod.getMethod().getName());
//        }
//    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        // 요청 종료 시 로깅
        long startTime = (long) request.getAttribute("startTime");
        long duration = System.currentTimeMillis() - startTime;

        logger.info("Completed request: {} {} - Status: {} - Duration: {}ms",
                request.getMethod(), request.getRequestURI(), response.getStatus(), duration);

        // 예외 로깅
//        if (ex != null) {
//            logger.error("Exception occurred: {}", ex.getMessage(), ex);
//        }
    }
}