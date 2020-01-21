package com.team2.products.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class CategoryDTO {

    private String categoryId;
    private String categoryName;
    private String image;


}
