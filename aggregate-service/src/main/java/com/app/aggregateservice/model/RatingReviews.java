package com.app.aggregateservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RatingReviews {
    private long productId;
    private String user;
    private int rating;
    private String comment;
}
