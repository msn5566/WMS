package com.wms.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document("locations")
public class Location {
    @Id
    private String locationId;
    private String zone;
    private String bin;
    private String type;
}