package com.wms.model;


import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SalesOrderItem {
    @DBRef
    private SKU sku;

    private int quantity;
    private BigDecimal unitPrice;

}