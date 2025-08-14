package com.wms.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document("putaway_tasks")
public class PutawayTask {
    @Id
    private String taskId;
    @DBRef
    private SKU sku;
    private int quantity;
    private String sourceLocation;
    private String targetLocation;
    private String status;
}