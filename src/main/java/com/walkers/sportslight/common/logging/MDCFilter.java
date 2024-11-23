package com.walkers.sportslight.common.logging;

import jakarta.servlet.*;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
public class MDCFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        String traceId = UUID.randomUUID().toString();
        MDC.put("traceId", traceId); // traceId 설정
        try {
            chain.doFilter(request, response); // 필터 체인 실행
        } finally {
            MDC.clear(); // 요청 처리 후 MDC 정리
        }
    }
}