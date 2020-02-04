package com.team2.products.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Document(collection = "subcategory")
@AllArgsConstructor
public class SubCategory {

    @Id
    private String subCategoryId;
    private String subCategoryName;
    private Category category;


}
