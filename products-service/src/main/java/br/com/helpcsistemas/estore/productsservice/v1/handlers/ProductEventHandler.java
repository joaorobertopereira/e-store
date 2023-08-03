package br.com.helpcsistemas.estore.productsservice.v1.handlers;

import br.com.helpcsistemas.estore.productsservice.v1.events.ProductCreatedEvent;

public interface ProductEventHandler {
    void on(ProductCreatedEvent event);
}
