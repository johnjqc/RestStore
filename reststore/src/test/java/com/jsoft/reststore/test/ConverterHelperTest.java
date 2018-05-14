package com.jsoft.reststore.test;

import com.jsoft.reststore.model.*;
import com.jsoft.reststore.model.web.BuyView;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * Helper to build objects for Test Class
 *
 * @since 0.0.
 * @author <a href="johnquirogac@gmail.com">John Quiroga</a>
 */
public class ConverterHelperTest {

    public static final Timestamp TIME = new Timestamp(System.currentTimeMillis());

    public static Buy buildBuy() {
        Buy buy = new Buy();

        buy.setBuyId(1L);
        buy.setTotalAmount(BigDecimal.ONE);
        buy.setTotalProduct(BigDecimal.ONE);
        buy.setInvoice(buildInvoice());
        buy.setInventory(buildInventory());

        return buy;
    }

    public static Inventory buildInventory() {
        Inventory inventory = new Inventory();

        inventory.setInventoryId(1L);
        inventory.setProduct(buildProduct());
        inventory.setShop(buildShop());
        inventory.setBuys(new ArrayList<>());
        inventory.setTotal(BigDecimal.TEN);

        return inventory;
    }

    public static Shop buildShop() {
        Shop shop = new Shop();

        shop.setShopId(1L);
        shop.setShopName("Name");
        shop.setAddress("Address");
        shop.setSchedule("Schedule");
        shop.setInventories(new ArrayList<>());

        return shop;
    }

    public static Product buildProduct() {
        Product product = new Product();

        product.setProductId(1L);
        product.setBarcode("barcode");
        product.setCost(BigDecimal.TEN);
        product.setProductName("name");
        product.setDescription("description");
        product.setInventories(new ArrayList<>());

        return product;
    }

    public static Invoice buildInvoice() {
        Invoice invoice = new Invoice();

        invoice.setInvoiceId(1L);
        invoice.setAmount(BigDecimal.ONE);
        invoice.setBuyDate(TIME);
        invoice.setClient(buildClient());
        invoice.setBuys(new ArrayList<>());

        return invoice;
    }

    public static Client buildClient() {
        Client client = new Client();

        client.setClientId(1L);
        client.setDocument(BigDecimal.TEN);
        client.setClientName("name");
        client.setAge(31);
        client.setEmail("email@email.com");
        client.setClientUser("user");
        client.setPassword("pwd");

        return client;
    }

    public static BuyView buildBuyView() {
        BuyView buyView = new BuyView();

        buyView.setBuyId(1L);
        buyView.setName("name");
        buyView.setTotalProduct(BigDecimal.ONE);
        buyView.setTotalAmount(BigDecimal.TEN);

        return buyView;
    }
}
