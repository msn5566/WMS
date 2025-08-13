package com.wms.repository;

import com.wms.model.InventoryAdjustment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryAdjustmentRepository extends MongoRepository<InventoryAdjustment, String> {

}