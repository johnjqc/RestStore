package com.jsoft.reststore.test.services;

import com.jsoft.reststore.model.Invoice;
import com.jsoft.reststore.model.common.StoreApiException;
import com.jsoft.reststore.repositories.jpa.BuyRepository;
import com.jsoft.reststore.service.*;
import com.jsoft.reststore.service.impl.BuyService;
import com.jsoft.reststore.test.AbstractMockitoTest;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.HashMap;
import java.util.Map;

import static com.jsoft.reststore.test.ConverterHelperTest.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

/**
 * Suite test class for BuyService
 *
 * @since 0.0.1
 * @author <a href="johnquirogac@gmail.com">John Quiroga</a>
 */
public class BuyServiceTest extends AbstractMockitoTest {

    private static final String USER = "user";
    private static final String PASSWORD = "password";
    private static final String BARCODE = " barcode";

    @Mock
    private ILoginService loginService;

    @Mock
    private IShopService shopService;

    @Mock
    private IProductService productService;

    @Mock
    private IInventoryService inventoryService;

    @Mock
    private IInvoiceService invoiceService;

    @Mock
    private BuyRepository buyRepository;

    @InjectMocks
    private BuyService buyService;

    @Test
    public void testBuyOk() throws StoreApiException {

        Map<String, Integer> productList = new HashMap<>();
        productList.put(BARCODE, 1);

        when(loginService.login(USER, PASSWORD)).thenReturn(buildClient());
        when(shopService.findById(1L)).thenReturn(buildShop());
        when(productService.findByBarcode(BARCODE)).thenReturn(buildProduct());
        when(inventoryService.findByProductAndShop(buildProduct(), buildShop())).thenReturn(buildInventory());
        when(invoiceService.save(any(Invoice.class))).thenReturn(buildInvoice());
        when(buyRepository.save(buildBuy())).thenReturn(buildBuy());

        Invoice actual = buyService.buy(USER, PASSWORD, 1L, productList);

        assertEquals(buildInvoice(), actual);
    }

}