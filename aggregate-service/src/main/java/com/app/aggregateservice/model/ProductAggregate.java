package com.app.aggregateservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor(staticName = "create")
@NoArgsConstructor
public class ProductAggregate {
    private Product product;
    private Promotion promotion;
    private List<RatingReviews> reviews;
}
