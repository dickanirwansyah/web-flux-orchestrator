package com.app.aggregateservice.service;

import com.app.aggregateservice.model.RatingReviews;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;

@Slf4j
@Service
public class ReviewClient {

    private final WebClient webClient;
    public ReviewClient(WebClient.Builder builder){
        this.webClient = builder
                .baseUrl("http://localhost:8083/api/v1/rating/list/")
                .build();
    }

    public Mono<List<RatingReviews>> getReviews(long productId){
        log.info("request rating review by product id={}",productId);
        return this.webClient.get()
                .uri(b -> b.queryParam("productId", productId).build())
                .retrieve()
                .bodyToFlux(RatingReviews.class).log()
                .collectList()
                .onErrorReturn(Collections.emptyList());
    }
}
