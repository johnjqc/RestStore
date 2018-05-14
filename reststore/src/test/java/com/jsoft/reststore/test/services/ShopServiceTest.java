package com.jsoft.reststore.test.services;

import com.jsoft.reststore.model.Shop;
import com.jsoft.reststore.model.common.StoreApiException;
import com.jsoft.reststore.repositories.jpa.ShopRepository;
import com.jsoft.reststore.service.impl.ShopService;
import com.jsoft.reststore.test.AbstractMockitoTest;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Optional;

import static com.jsoft.reststore.test.ConverterHelperTest.buildShop;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Suite test class for ShopService
 *
 * @since 0.0.1
 * @author <a href="johnquirogac@gmail.com">John Quiroga</a>
 */
public class ShopServiceTest extends AbstractMockitoTest {

    @Mock
    private ShopRepository shopRepository;

    @InjectMocks
    private ShopService shopService;

    @Test
    public void testFindByIdOk() throws StoreApiException {

        when(shopRepository.findById(1L)).thenReturn(Optional.of(buildShop()));

        Shop shop = shopService.findById(1L);

        assertEquals(shop, buildShop());
    }

    @Test(expected = StoreApiException.class)
    public void testFindByIdFail() throws StoreApiException {

        when(shopRepository.findById(1L)).thenReturn(Optional.empty());
        shopService.findById(1L);
    }

}
