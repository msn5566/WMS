package com.wms.model;

// Mockito imports
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.ArgumentCaptor;

// JUnit 5 imports
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

// Spring Test imports (for controller tests)
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// Mockito static imports
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;

// Jackson imports (if testing JSON serialization)
import com.fasterxml.jackson.databind.ObjectMapper;

// Jakarta imports (if testing XML/validation)
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;


import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class ProductTest {

    @Test
    void builderTest() {
        Product product = Product.builder()
                .productId("testId")
                .name("testName")
                .description("testDescription")
                .category("testCategory")
                .unitOfMeasure("testUnitOfMeasure")
                .active(true)
                .build();

        assertEquals("testId", product.getProductId());
        assertEquals("testName", product.getName());
        assertEquals("testDescription", product.getDescription());
        assertEquals("testCategory", product.getCategory());
        assertEquals("testUnitOfMeasure", product.getUnitOfMeasure());
        assertTrue(product.isActive());
    }
}