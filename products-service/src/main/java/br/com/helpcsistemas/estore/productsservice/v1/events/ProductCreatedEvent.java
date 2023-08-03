package br.com.helpcsistemas.estore.productsservice.v1.events;

import br.com.helpcsistemas.estore.productsservice.v1.model.Product;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class ProductCreatedEvent implements Serializable {
    private String id;
    private Product product;
}
