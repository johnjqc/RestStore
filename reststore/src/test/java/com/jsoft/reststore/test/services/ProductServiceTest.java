package com.jsoft.reststore.test.services;

import com.jsoft.reststore.model.Product;
import com.jsoft.reststore.model.common.StoreApiException;
import com.jsoft.reststore.repositories.jpa.ProductRepository;
import com.jsoft.reststore.service.impl.ProductService;
import com.jsoft.reststore.test.AbstractMockitoTest;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static com.jsoft.reststore.test.ConverterHelperTest.buildProduct;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class ProductServiceTest extends AbstractMockitoTest {

    private static final String BARCODE = " barcode";

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    public void testFindByBarcodeOk() throws StoreApiException {

        when(productRepository.findByBarcode(BARCODE)).thenReturn(buildProduct());

        Product product = productService.findByBarcode(BARCODE);

        assertEquals(product, buildProduct());
    }

    @Test(expected = StoreApiException.class)
    public void testFindByBarcodeFail() throws StoreApiException {
        when(productRepository.findByBarcode(BARCODE)).thenReturn(null);

        Product product = productService.findByBarcode(BARCODE);
    }

}
