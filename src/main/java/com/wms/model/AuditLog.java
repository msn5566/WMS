package com.wms.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@Builder
@Document("audit_logs")
public class AuditLog {
    @Id
    private String logId;
    private String userId;
    private String action;
    private String entity;
    private LocalDateTime timestamp;
    private String details;
}