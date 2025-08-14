package com.wms.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("sales_orders")
public class SalesOrder {

    @Id
    private String salesOrderId;
    private String customer; // Customer entity and @DBRef would be better in a real app
    private LocalDateTime orderDate;
    private List<SalesOrderItem> items;
}