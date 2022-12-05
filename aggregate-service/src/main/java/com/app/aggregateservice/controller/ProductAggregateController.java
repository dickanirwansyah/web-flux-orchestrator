package com.app.aggregateservice.controller;

import com.app.aggregateservice.model.ProductAggregate;
import com.app.aggregateservice.service.ProductAggregateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RequestMapping(value = "/api/v1/product-aggregate")
@RestController
public class ProductAggregateController {

    @Autowired
    private ProductAggregateService productAggregateService;

    @GetMapping(value = "/{productId}")
    public Mono<ResponseEntity<ProductAggregate>> getProduct(@PathVariable("productId")Long productId){
        return this.productAggregateService.getProduct(productId)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound()
                        .build());
    }
}
