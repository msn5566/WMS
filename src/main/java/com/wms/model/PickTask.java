package com.wms.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("pick_tasks")
public class PickTask {
    @Id
    private String taskId;

    @DBRef
    private SKU sku;

    private int quantity;
    private String fromLocation; // Consider referencing Location object
    private String orderId; // Consider referencing SalesOrder object
    private String status; // e.g., pending, in-progress, completed, cancelled
}