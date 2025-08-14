package com.wms.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("skus")
public class SKU {

    @Id
    private String skuId;

    @DBRef // For MongoDB
    private Product product;
    private String barcode;
    private BigDecimal price;
    private double weight;
    private String status; // You might want to use an enum here in a real application
}