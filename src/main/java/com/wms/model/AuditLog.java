package com.wms.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("audit_logs")
public class AuditLog {

    @Id
    private String logId;

    private String userId; // Consider referencing User object
    private String action; // CRUD operations
    private String entity;
    private LocalDateTime timestamp;
    private String details;
}