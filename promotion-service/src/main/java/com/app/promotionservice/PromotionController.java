package com.app.promotionservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequestMapping(value = "/api/v1/promotion")
@RestController
public class PromotionController {

    @GetMapping(value = "/list/{productId}")
    public Promotion getPromotions(@PathVariable("productId")Long productId){
        log.info("call list promotion");
        Promotion promotion1 = new Promotion();
        promotion1.setId(1l);
        promotion1.setType("christmas sale");
        promotion1.setDiscount(12.0);
        promotion1.setEndDate("2022-12-26");

        Promotion promotion2 = new Promotion();
        promotion2.setId(3l);
        promotion2.setType("new year sale");
        promotion2.setDiscount(6.0);
        promotion2.setEndDate("2022-12-31");
        List<Promotion> promotionList =  List.of(promotion1, promotion2);

        return promotionList.stream().filter(promotion -> promotion.getId().equals(productId))
                .collect(Collectors.toList()).get(0);
    }
}
