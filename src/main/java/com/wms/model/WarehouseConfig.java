package com.wms.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("warehouse_config")
public class WarehouseConfig {
    @Id
    private String configId;
    private String key;
    private String value;

}