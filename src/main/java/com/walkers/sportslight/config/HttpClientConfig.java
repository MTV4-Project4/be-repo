package com.walkers.sportslight.config;
import com.walkers.sportslight.httpConnection.AiHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import java.net.http.HttpClient;
import java.time.Duration;

@Configuration
public class HttpClientConfig {


    @Bean
    public WebClient webClient() {
        // 메모리 크기 무제한 설정 및 WebClient 구성
        ExchangeStrategies exchangeStrategies = ExchangeStrategies.builder()
                .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(-1)) // 메모리 제한 없음
                .build();

        return WebClient.builder()
                .baseUrl("http://metaai2.iptime.org:7900/") // 기본 URL
                .exchangeStrategies(exchangeStrategies)
                .build();
    }

    @Bean
    public AiHttpClient aiHttpClient(WebClient webClient) {
        // WebClientAdapter를 사용하여 HttpServiceProxyFactory 생성
        HttpServiceProxyFactory proxyFactory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(webClient))
                .build();

        return proxyFactory.createClient(AiHttpClient.class);
    }
}
