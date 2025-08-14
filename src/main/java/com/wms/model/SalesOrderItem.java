package com.wms.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SalesOrderItem {

    @DBRef
    private SKU sku;
    private int quantity;
}