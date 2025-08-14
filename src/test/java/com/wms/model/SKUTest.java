
package com.wms.model;

// [Standard imports as previous examples]
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class SKUTest {

    @Mock
    private Product product;


    @Test
    void builderTest() {
        SKU sku = SKU.builder()
                .skuId("testSkuId")
                .product(product)
                .barcode("testBarcode")
                .price(BigDecimal.TEN)
                .weight(10.0)
                .status("testStatus")
                .build();

        assertAll(
                () -> assertEquals("testSkuId", sku.getSkuId()),
                () -> assertEquals(product, sku.getProduct()),
                () -> assertEquals("testBarcode", sku.getBarcode()),
                () -> assertEquals(BigDecimal.TEN, sku.getPrice()),
                () -> assertEquals(10.0, sku.getWeight()),
                () -> assertEquals("testStatus", sku.getStatus())
        );
    }

}