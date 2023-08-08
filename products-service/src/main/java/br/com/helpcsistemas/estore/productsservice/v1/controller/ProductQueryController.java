package br.com.helpcsistemas.estore.productsservice.v1.controller;

import br.com.helpcsistemas.estore.productsservice.v1.dto.ProductDto;
import br.com.helpcsistemas.estore.productsservice.v1.query.FindProductsQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("estore/v1/products")
public class ProductQueryController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final QueryGateway queryGateway;

    public ProductQueryController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getProducts() {
        FindProductsQuery findProductsQuery = new FindProductsQuery();
        List<ProductDto> productDtoList = queryGateway.query(findProductsQuery, ResponseTypes.multipleInstancesOf(ProductDto.class)).join();
        return new ResponseEntity<>(productDtoList, HttpStatus.OK);
    }

}
