package br.com.helpcsistemas.estore.productsservice.v1.handlers;

import br.com.helpcsistemas.estore.productsservice.v1.events.ProductCreatedEvent;
import br.com.helpcsistemas.estore.productsservice.v1.repository.ProductRepository;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

@Service
@ProcessingGroup("product-group")
public class ProductEventHandlerImpl implements ProductEventHandler {

    private final ProductRepository repository;

    public ProductEventHandlerImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    @EventHandler
    public void on(ProductCreatedEvent event) { repository.save(event.getProduct()); }

}
