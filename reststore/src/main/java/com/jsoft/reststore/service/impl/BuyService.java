package com.jsoft.reststore.service.impl;

import com.jsoft.reststore.model.*;
import com.jsoft.reststore.model.common.ApiResponseCode;
import com.jsoft.reststore.model.common.StoreApiException;
import com.jsoft.reststore.repositories.jpa.BuyRepository;
import com.jsoft.reststore.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The service implementation for buy operations
 *
 * @author <a href="johnquirogac@gmail.com">John Quiroga</a>
 * @since 0.0.1
 */
@Service
public class BuyService extends AbstractService<BuyRepository, Buy> implements IBuyService {

    @Autowired
    private ILoginService loginService;

    @Autowired
    private IShopService shopService;

    @Autowired
    private IProductService productService;

    @Autowired
    private IInventoryService inventoryService;

    @Autowired
    private IInvoiceService invoiceService;

    @Override
    public Invoice buy(String user, String password, Long shopId, Map<String, Integer> productList) throws StoreApiException {

        Client client = loginService.login(user, password);
        Shop shop = shopService.findById(shopId);

        List<Buy> buyList = buildBuyList(shop, productList);
        Invoice invoice = invoiceService.save(buildInvoice(client, buyList));

        for (Buy buy : buyList) {
            buy.setInvoice(invoice);
            buy = save(buy);
        }

        updateInventory(shop, productList);

        return invoice;
    }

    /**
     * Update total of producto on inventory for each shop
     * @param shop the shop
     * @param productList the product list with require quantity
     * @throws StoreApiException
     */
    private void updateInventory(Shop shop, Map<String, Integer> productList) throws StoreApiException {

        for (Map.Entry<String, Integer> entry : productList.entrySet()) {
            Product product = productService.findByBarcode(entry.getKey());
            Inventory inventory = inventoryService.findByProductAndShop(product, shop);

            inventory.setTotal(inventory.getTotal().subtract(new BigDecimal(entry.getValue())));
            inventoryService.save(inventory);
        }
    }

    /**
     * Build the list of item on order buy and validate if inventory have disponibility
     * @param shop the shop
     * @param productList the product list with require quantity
     * @return the list buy detailed
     * @throws StoreApiException
     */
    private List<Buy> buildBuyList(Shop shop, Map<String, Integer> productList) throws StoreApiException {
        List<Buy> buyList = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : productList.entrySet()) {
            Product product = productService.findByBarcode(entry.getKey());
            Inventory inventory = inventoryService.findByProductAndShop(product, shop);

            if (inventoryHasSufficientProduct(inventory.getTotal(), entry.getValue(), product.getProductName())) {
                Buy buy = new Buy();
                buy.setInventory(inventory);
                buy.setTotalProduct(new BigDecimal(entry.getValue()));
                buy.setTotalAmount(getTotalBuyAmount(entry.getValue(), product.getCost()));

                buyList.add(buy);
            }
        }

        return buyList;
    }

    /**
     * Build the invoince for buy
     * @param client the client of the buy
     * @param buyList the buy list of products
     * @return the invoice
     */
    private static Invoice buildInvoice(Client client, List<Buy> buyList) {
        Invoice invoice = new Invoice();
        invoice.setClient(client);
        invoice.setBuyDate(new Timestamp(System.currentTimeMillis()));
        invoice.setBuys(buyList);
        invoice.setAmount(buyList.stream().map(Buy::getTotalAmount).reduce(BigDecimal.ZERO, BigDecimal::add));

        return invoice;
    }

    /**
     * Validate if total of inventory is less than required products
     * @param total the total of inventory
     * @param required the required products
     * @param name the name of product
     * @return True if inventory has required quantity
     * @throws StoreApiException
     */
    private static boolean inventoryHasSufficientProduct(BigDecimal total, int required, String name) throws StoreApiException {
        if (total.compareTo(new BigDecimal(required)) < 0) {
            throw new StoreApiException(ApiResponseCode.INSUFFICIENT_PRODUCT, "The shop not have sufficient " + name);
        }
        return true;
    }

    /**
     * calculate the total o buy by product
     * @param totalProduct the total of products
     * @param cost the cost of product
     * @return the total amount
     */
    private static BigDecimal getTotalBuyAmount(int totalProduct, BigDecimal cost) {

        return cost.multiply(new BigDecimal(totalProduct));
    }
}
