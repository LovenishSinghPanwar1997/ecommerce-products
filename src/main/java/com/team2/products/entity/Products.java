package com.team2.products.entity;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Document(collection = "products")
@Builder
@AllArgsConstructor
public class Products {

    @Id
    private String productId;
    private String productName;
    private List<String> images;
    private Map<String,String> attributes;

    private Category category;


    private SubCategory subCategory;

}
