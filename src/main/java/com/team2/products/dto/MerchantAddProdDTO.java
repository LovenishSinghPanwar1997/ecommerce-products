package com.team2.products.dto;

import lombok.*;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MerchantAddProdDTO {

    private String productId;
    private String productName;
    private Double productPrice;
    private String productDescription;
    private Map<String,String> attributes;
    private String usp;
    private List<String> categories;
    private List<String> images;
    private Integer quantity;
    private String merchantId;

}
