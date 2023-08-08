package br.com.helpcsistemas.estore.productsservice.v1.handlers;

import br.com.helpcsistemas.estore.productsservice.v1.dto.ProductDto;
import br.com.helpcsistemas.estore.productsservice.v1.model.Product;
import br.com.helpcsistemas.estore.productsservice.v1.query.FindProductsQuery;
import br.com.helpcsistemas.estore.productsservice.v1.repository.ProductRepository;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.queryhandling.QueryHandler;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@ProcessingGroup("product-query-group")
public class ProductsQueryHandlerImpl implements ProductsQueryHandler {

    private final ProductRepository repository;

    private final ModelMapper modelMapper;

    public ProductsQueryHandlerImpl(ProductRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    @QueryHandler
    public List<ProductDto> findProducts(FindProductsQuery query) {
        List<Product> productList = repository.findAll();
        return Arrays.asList(modelMapper.map(productList, ProductDto[].class));
    }

}
