package com.team2.products.dto.response;

import com.team2.products.entity.Products;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryListResponse {
    private String id;
    private String image;
    private String name;
    private List<ProductListResponse> products;
}
