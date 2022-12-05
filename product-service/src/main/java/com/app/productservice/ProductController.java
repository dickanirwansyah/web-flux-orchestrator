package com.app.productservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequestMapping(value = "/api/v1/product")
@RestController
public class ProductController {

    @GetMapping(value = "/list/{id}")
    public Product getProducts(@PathVariable("id")Long id){
        log.info("call list product");
        Product product1 = new Product();
        product1.setId(1l);
        product1.setCategory("electronics");
        product1.setDescription("iphone");

        Product product2 = new Product();
        product2.setId(2l);
        product2.setCategory("kitchen");
        product2.setDescription("air-fryer");

        Product product3 = new Product();
        product3.setId(3l);
        product3.setCategory("pet supplies");
        product3.setDescription("calming pet bed");

        List<Product> dataProducts =  List.of(product1, product2, product3);
        return dataProducts.stream().filter(product -> product.getId().equals(id))
                .collect(Collectors.toList()).get(0);
    }
}
