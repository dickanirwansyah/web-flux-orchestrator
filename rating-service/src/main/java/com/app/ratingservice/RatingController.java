package com.app.ratingservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequestMapping(value = "/api/v1/rating")
@RestController
public class RatingController {

    @GetMapping(value = "/list")
    public List<RatingReviews> getList(@RequestParam("productId")Long productId){
        log.info("call list rating");
        RatingReviews ratingReviews1 = new RatingReviews();
        ratingReviews1.setProductId(1l);
        ratingReviews1.setUser("sam");
        ratingReviews1.setRating(4);
        ratingReviews1.setComment("it is good");

        RatingReviews ratingReviews2 = new RatingReviews();
        ratingReviews2.setProductId(2l);
        ratingReviews2.setUser("jake");
        ratingReviews2.setRating(2);
        ratingReviews2.setComment("stopped working after 2 weeks");

        List<RatingReviews> ratingReviews = List.of(ratingReviews1, ratingReviews2);
        return ratingReviews.stream()
                .filter(data -> data.getProductId().equals(productId))
                .collect(Collectors.toList());
    }
}
