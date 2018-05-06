package com.jsoft.reststore.controller;

import com.jsoft.reststore.model.Product;
import com.jsoft.reststore.model.converter.ProductConverter;
import com.jsoft.reststore.model.web.ProductResponse;
import com.jsoft.reststore.model.web.ProductView;
import com.jsoft.reststore.service.IProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(path = "/product")
public class ProductController {

    /**
     * The {@link ProductController} logger
     */
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private IProductService productService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<ProductResponse> queryAll() {
        ProductResponse apiResponse = new ProductResponse();
        ResponseEntity<ProductResponse> httpResponse = new ResponseEntity<>(apiResponse,
                HttpStatus.FOUND);

        logger.debug("Query all Products");

        List<Product> list = productService.findAll();

        if (!list.isEmpty()) {
            apiResponse.setProductList(list.stream()
                    .map(ProductConverter::webToDomain)
                    .collect(Collectors.toList()));
        }

        return httpResponse;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<ProductResponse> createProduct(@Valid @RequestBody ProductView product) {
        ProductResponse apiResponse = new ProductResponse();
        ResponseEntity<ProductResponse> httpResponse = new ResponseEntity<>(apiResponse,
                HttpStatus.CREATED);

        Product createdProduct = productService.save(ProductConverter.domainToWeb(product));
        apiResponse.setProduct(ProductConverter.webToDomain(createdProduct));

        return httpResponse;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ResponseEntity<ProductResponse> deleteProduct(@PathVariable("id") Long id) {
        ProductResponse apiResponse = new ProductResponse();
        ResponseEntity<ProductResponse> httpResponse = new ResponseEntity<>(apiResponse, HttpStatus.OK);

        productService.deleteById(id);

        return httpResponse;
    }
}
