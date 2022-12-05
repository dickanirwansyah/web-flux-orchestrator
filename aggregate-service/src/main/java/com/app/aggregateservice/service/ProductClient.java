package com.app.aggregateservice.service;

import com.app.aggregateservice.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class ProductClient {

    private final WebClient webClient;

    public ProductClient(WebClient.Builder builder){
        this.webClient = builder
                .baseUrl("http://localhost:8081/api/v1/product/list/")
                .build();
    }

    public Mono<Product> getProduct(Long productId){
        log.info("request product id={}",productId);
        return this.webClient.get()
                .uri("{productId}", productId)
                .retrieve()
                .bodyToMono(Product.class).log()
                .onErrorResume(ex -> Mono.empty());
    }
}
