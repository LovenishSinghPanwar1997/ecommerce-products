package com.team2.products.dto;

import lombok.*;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductsDTO {

    private String productId;
    private String productName;
    private List<String> images;
    private Map<String,String> attributes;
    private String categoryId;

}
