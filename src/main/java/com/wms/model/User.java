package com.wms.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document("users") // For MongoDB
public class User {
    @Id
    private String id;
    private String username;
    private String password;
    private String role;
    private boolean active;
}