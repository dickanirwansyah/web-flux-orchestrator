package com.app.aggregateservice.service;

import com.app.aggregateservice.model.Promotion;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class PromotionClient {

    private final WebClient webClient;

    public PromotionClient(WebClient.Builder builder){
        this.webClient = builder
                .baseUrl("http://localhost:8082/api/v1/promotion/list/")
                .build();
    }

    public Mono<Promotion> getPromotion(long productId){
        log.info("request promo by productId={}",productId);
        Promotion noPromotion = new Promotion();
        noPromotion.setDiscount(0.0);
        noPromotion.setType("no-promotion");
        noPromotion.setEndDate("2022-01-01");
        return this.webClient
                .get()
                .uri("{productId}", productId)
                .retrieve()
                .bodyToMono(Promotion.class).log()
                .onErrorReturn(noPromotion);
    }
}


