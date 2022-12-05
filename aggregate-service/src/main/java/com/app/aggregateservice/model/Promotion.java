package com.app.aggregateservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Promotion {
    private long id;
    private String type;
    private double discount;
    private String endDate;
}
