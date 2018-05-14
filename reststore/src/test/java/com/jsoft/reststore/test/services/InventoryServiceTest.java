package com.jsoft.reststore.test.services;

import com.jsoft.reststore.model.Inventory;
import com.jsoft.reststore.model.common.StoreApiException;
import com.jsoft.reststore.repositories.jpa.InventoryRepository;
import com.jsoft.reststore.service.impl.InventoryService;
import com.jsoft.reststore.test.AbstractMockitoTest;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;


import static com.jsoft.reststore.test.ConverterHelperTest.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Suite test class for InventoryService
 *
 * @since 0.0.1
 * @author <a href="johnquirogac@gmail.com">John Quiroga</a>
 */
public class InventoryServiceTest extends AbstractMockitoTest {

    @Mock
    private InventoryRepository inventoryRepository;

    @InjectMocks
    private InventoryService inventoryService;

    @Test
    public void testFindByProductAndShopOk() throws StoreApiException {

        when(inventoryRepository.findByProductAndShop(buildProduct(), buildShop())).thenReturn(buildInventory());

        Inventory inventory = inventoryService.findByProductAndShop(buildProduct(), buildShop());

        assertEquals(inventory, buildInventory());
    }

    @Test(expected = StoreApiException.class)
    public void testFindByProductAndShopFail() throws StoreApiException {

        when(inventoryRepository.findByProductAndShop(buildProduct(), buildShop())).thenReturn(null);

        inventoryService.findByProductAndShop(buildProduct(), buildShop());
    }

}
