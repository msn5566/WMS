package com.wms.service;

import com.wms.dto.StockAdjustmentDto;

public interface StockAdjustmentService {
    void adjustStock(StockAdjustmentDto stockAdjustmentDto);

}