package com.app.aggregateservice.service;

import com.app.aggregateservice.model.Product;
import com.app.aggregateservice.model.ProductAggregate;
import com.app.aggregateservice.model.Promotion;
import com.app.aggregateservice.model.RatingReviews;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple3;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class ProductAggregateService {

    private final ProductClient productClient;
    private final PromotionClient promotionClient;
    private final ReviewClient reviewClient;

    public Mono<ProductAggregate> getProduct(Long productId){
        return Mono.zip(
                this.productClient.getProduct(productId),
                this.promotionClient.getPromotion(productId),
                this.reviewClient.getReviews(productId)
        ).map(this::combine);
    }

    private ProductAggregate combine(Tuple3<Product, Promotion, List<RatingReviews>> tuple){
        return ProductAggregate.create(
                tuple.getT1(),
                tuple.getT2(),
                tuple.getT3());
    }
}
