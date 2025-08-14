package com.wms.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document("warehouse_config")
public class WarehouseConfig {
    @Id
    private String configId;
    private String key;
    private String value;
}