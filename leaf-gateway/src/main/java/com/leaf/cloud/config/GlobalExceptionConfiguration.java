package com.leaf.cloud.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.leaf.cloud.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import com.fasterxml.jackson.databind.ObjectMapper;

@Slf4j
@Configuration
public class GlobalExceptionConfiguration {

    private final ObjectMapper objectMapper;

    public GlobalExceptionConfiguration(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Bean
    @Order(-1)
    public ErrorWebExceptionHandler errorWebExceptionHandler() {
        return (exchange, ex) -> {
            ServerHttpResponse response = exchange.getResponse();
            if (response.isCommitted()) {
                return Mono.error(ex);
            }
            response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
            if (ex instanceof ResponseStatusException) {
                response.setStatusCode(((ResponseStatusException) ex).getStatusCode());
            }
            return response.writeWith(Mono.fromSupplier(() -> {
                DataBufferFactory bufferFactory = response.bufferFactory();
                try {
                    return bufferFactory.wrap(objectMapper.writeValueAsBytes(R.error(ex.getMessage())));
                } catch (JsonProcessingException e) {
                    log.warn("Error writing response", ex);
                    return bufferFactory.wrap(new byte[0]);
                }
            }));
        };
    }
}