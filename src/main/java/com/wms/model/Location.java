package com.wms.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("locations")
public class Location {

    @Id
    private String locationId;
    private String zone;
    private String bin;
    private String type; // e.g., receiving, storage, shipping
}