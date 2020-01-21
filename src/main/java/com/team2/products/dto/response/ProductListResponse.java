package com.team2.products.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductListResponse {
    private String id;
    private String name;
    private int price;
    private String image;
}
