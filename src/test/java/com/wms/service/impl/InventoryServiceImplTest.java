package com.wms.service.impl;

// Required imports (see instructions)
import com.wms.dto.InventoryDto;
import com.wms.model.Inventory;
import com.wms.repository.InventoryRepository;
import com.wms.service.InventoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class InventoryServiceImplTest {
    @Mock
    private InventoryRepository inventoryRepository;
    @InjectMocks
    private InventoryServiceImpl inventoryService;


    @Test
    void shouldAddInventory_whenValidDtoProvided() {
        InventoryDto inventoryDto = createSampleInventoryDto();
        when(inventoryRepository.save(any(Inventory.class))).thenReturn(convertDtoToEntity(inventoryDto));
        inventoryService.addInventory(inventoryDto);
        verify(inventoryRepository, times(1)).save(any(Inventory.class));
    }


    @Test
    void shouldUpdateInventory_whenInventoryExists() {

        InventoryDto inventoryDto = createSampleInventoryDto();
        Inventory existingInventory = convertDtoToEntity(inventoryDto);

        when(inventoryRepository.findBySkuAndLocationId(inventoryDto.getSkuId(), inventoryDto.getLocationId()))
                .thenReturn(Optional.of(existingInventory));
        when(inventoryRepository.save(any(Inventory.class))).thenReturn(existingInventory);

        inventoryService.updateInventory(inventoryDto);


        verify(inventoryRepository, times(1)).findBySkuAndLocationId(inventoryDto.getSkuId(), inventoryDto.getLocationId());
        verify(inventoryRepository, times(1)).save(any(Inventory.class));

        assertEquals(inventoryDto.getQuantity(), existingInventory.getQuantity());


    }


    @Test
    void shouldDeleteInventory_whenInventoryExists() {
        String skuId = "sku123";
        String locationId = "loc456";

        InventoryDto inventoryDto = createSampleInventoryDto();
        Inventory existingInventory = convertDtoToEntity(inventoryDto);

        when(inventoryRepository.findBySkuAndLocationId(skuId, locationId))
                .thenReturn(Optional.of(existingInventory));

        inventoryService.deleteInventory(skuId, locationId);
        verify(inventoryRepository).delete(existingInventory);
    }



    @Test
    void shouldGetInventory_whenInventoryExists() {

        InventoryDto inventoryDto = createSampleInventoryDto();
        Inventory existingInventory = convertDtoToEntity(inventoryDto);

        when(inventoryRepository.findBySkuAndLocationId(inventoryDto.getSkuId(), inventoryDto.getLocationId()))
                .thenReturn(Optional.of(existingInventory));


        InventoryDto resultDto = inventoryService.getInventory(inventoryDto.getSkuId(), inventoryDto.getLocationId());

        verify(inventoryRepository).findBySkuAndLocationId(inventoryDto.getSkuId(), inventoryDto.getLocationId());

        assertEquals(inventoryDto.getSkuId(), resultDto.getSkuId());
        assertEquals(inventoryDto.getLocationId(), resultDto.getLocationId());
        assertEquals(inventoryDto.getQuantity(), resultDto.getQuantity());

    }




    private InventoryDto createSampleInventoryDto() {
        return InventoryDto.builder()
                .inventoryId("inv789")
                .skuId("sku123")
                .locationId("loc456")
                .quantity(100)
                .lastUpdated(LocalDateTime.now())
                .build();
    }

    private Inventory convertDtoToEntity(InventoryDto inventoryDto) {
        return Inventory.builder()
                .inventoryId(inventoryDto.getInventoryId())
                .sku(inventoryDto.getSkuId())
                .locationId(inventoryDto.getLocationId())
                .quantity(inventoryDto.getQuantity())
                .lastUpdated(inventoryDto.getLastUpdated())
                .build();
    }

}