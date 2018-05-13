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

    @Override
    public Invoice buy(String user, String password, Long shopId, Map<String, Integer> productList) throws StoreApiException {

        Client client = loginService.login(user, password);
        Shop shop = shopService.findById(shopId);

        List<Buy> buyList = buildBuyList(shopId, productList);
        Invoice invoice = buildInvoice(client, buyList);
        buyList.forEach( buy -> buy.setInvoice(invoice));

        return invoice;
    }

    private List<Buy> buildBuyList(Long shopId, Map<String, Integer> productList) throws StoreApiException {
        List<Buy> buyList = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : productList.entrySet()) {
            Product product = productService.findByBarcode(entry.getKey());
            Inventory inventory = inventoryService.findByProductAndShop(product.getProductId(), shopId);

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

    private static Invoice buildInvoice(Client client, List<Buy> buyList) {
        Invoice invoice = new Invoice();
        invoice.setClient(client);
        invoice.setBuyDate(new Timestamp(System.currentTimeMillis()));
        invoice.setBuys(buyList);

        return invoice;
    }

    private static boolean inventoryHasSufficientProduct(BigDecimal total, int required, String name) throws StoreApiException {
        if (total.compareTo(new BigDecimal(required)) < 0) {
            throw new StoreApiException(ApiResponseCode.INSUFFICIENT_PRODUCT, "The shop not have sufficient " + name);
        }
        return true;
    }

    private static BigDecimal getTotalBuyAmount(int totalProduct, BigDecimal cost) {

        return cost.multiply(new BigDecimal(totalProduct));
    }
}
