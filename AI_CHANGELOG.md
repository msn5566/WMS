

---
**Date:** 2025-08-12 17:09:37
**Branch:** feature/WMS-1_20250812170853
---

```markdown
### Changelog
- ✅ Added: Create POJOs for Warehouse Management System
```
--- END ---


---
**Date:** 2025-08-12 17:13:30
**Branch:** feature/WMS-2_20250812171222
---

```markdown
### Changelog
- 🔄 Modified: Story title changed from "Create POJOs for Warehouse Management System" to "Implement user registration and login".
- 🔄 Modified: Story description and scope were replaced with a description focused on user registration and authentication with roles.
- ❌ Removed: Acceptance Criteria section was removed.
- ❌ Removed: List of POJOs was removed.
```
--- END ---


---
**Date:** 2025-08-12 18:02:00
**Branch:** feature/WMS-5_20250812180026
---

### Changelog
- 🔄 Modified: Story summary and description changed from "Create POJOs for Warehouse Management System\n\nDefine and implement core entity classes (POJOs) required for the Warehouse Management System. These classes will model the system's domain and serve as the foundation for data persistence, business logic, and API interactions.\n\n**Scope Includes:**\n-User (id, username, password, role, active)\n\nProduct (productId, name, description, category, unitOfMeasure, active)\n\nSKU (skuId, product, barcode, price, weight, status)\n\nInventory (inventoryId, sku, locationId, quantity, lastUpdated)\n\nLocation (locationId, zone, bin, type)\n\nPurchaseOrder and PurchaseOrderItem\n\nSalesOrder and SalesOrderItem\n\nPutawayTask (taskId, sku, quantity, sourceLocation, targetLocation, status)\n\nPickTask (taskId, sku, quantity, fromLocation, orderId, status)\n\nAuditLog (logId, userId, action, entity, timestamp, details)\n\nInventoryAdjustment (adjustmentId, sku, beforeQty, afterQty, reason, adjustedBy, timestamp)\n\nWarehouseConfig (configId, key, value)\n\n**Acceptance Criteria:**\n\n* All POJO classes are created under `com.company.wms.model`\n* Fields follow Java naming conventions and use appropriate types\n* Use Lombok annotations like `@Data`, `@Builder`, etc.\n* Ready for JPA or MongoDB annotations" to "Implement inventory tracking APIs\n\nCreate APIs to add, update, delete and view inventory by SKU and location."
- ❌ Removed: Acceptance Criteria from the description.
- ❌ Removed: Scope Includes from the description.

--- END ---
