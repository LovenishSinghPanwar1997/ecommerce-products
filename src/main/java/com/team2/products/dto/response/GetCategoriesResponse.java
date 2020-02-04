package com.team2.products.dto.response;

import com.team2.products.entity.Category;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCategoriesResponse {
    private List<CategoryListResponse> categories;
}
