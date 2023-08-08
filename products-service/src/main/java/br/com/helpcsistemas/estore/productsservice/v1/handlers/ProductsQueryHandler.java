package br.com.helpcsistemas.estore.productsservice.v1.handlers;

import br.com.helpcsistemas.estore.productsservice.v1.dto.ProductDto;
import br.com.helpcsistemas.estore.productsservice.v1.query.FindProductsQuery;

import java.util.List;

public interface ProductsQueryHandler {
    List<ProductDto> findProducts(FindProductsQuery query);
}
