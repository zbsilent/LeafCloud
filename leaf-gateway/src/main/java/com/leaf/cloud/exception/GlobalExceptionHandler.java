package com.leaf.cloud.exception;




import com.leaf.cloud.common.R;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


/**
 * @author zbsilent
 * @version 1.0
 * @description: TODO
 * @date 2024/7/3 上午12:02
 */
@RestControllerAdvice
@Order(-2) // 可以通过Order调整处理优先级
public class GlobalExceptionHandler {

     @ExceptionHandler(value = Exception.class)
    public Mono<ResponseEntity<Object>> handleException(ServerWebExchange exchange, Throwable ex) {
        ServerHttpRequest request = exchange.getRequest();
        // 这里可以根据异常类型或者业务逻辑定制响应内容
        String errorMessage = "An unexpected error occurred: " + ex.getMessage();
        return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage));
    }

    // 你可以为特定的异常类型添加更多的@ExceptionHandler方法
    // 例如，针对ResponseStatusException的处理
    @ExceptionHandler(value = ResponseStatusException.class)
    public Mono<R<Object>> handleResponseStatusException(ServerWebExchange exchange, ResponseStatusException ex) {
        // 根据ResponseStatusException定制响应
        //return Mono.just(ResponseEntity.status(ex.getStatusCode()).body(ex.getReason()));
        return Mono.just(R.error(ex.getStatusCode().value(),ex.getReason()));
    }
}
