package com.wms.model;


import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@Document("sales_orders")
public class SalesOrder {
    @Id
    private String salesOrderId;
    private String customer;
    private LocalDateTime orderDate;
    private List<SalesOrderItem> items;
}