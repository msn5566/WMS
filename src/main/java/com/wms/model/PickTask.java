package com.wms.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document("pick_tasks")
public class PickTask {
    @Id
    private String taskId;
    @DBRef
    private SKU sku;
    private int quantity;
    private String fromLocation;
    private String orderId;
    private String status;
}