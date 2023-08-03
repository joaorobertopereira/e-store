package br.com.helpcsistemas.estore.productsservice.v1.aggregate;

import br.com.helpcsistemas.estore.productsservice.v1.command.CreateProductCommand;
import br.com.helpcsistemas.estore.productsservice.v1.events.ProductCreatedEvent;
import br.com.helpcsistemas.estore.productsservice.v1.model.Product;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class ProductAggregate {

    @AggregateIdentifier
    private String id;
    private Product product;

    protected ProductAggregate() {}

    @CommandHandler
    public ProductAggregate(CreateProductCommand command) {
        Product newProduct = command.getProduct();
        newProduct.setId(command.getId());

        ProductCreatedEvent createdEvent = ProductCreatedEvent.builder()
                .id(command.getId())
                .product(newProduct)
                .build();

        AggregateLifecycle.apply(createdEvent);

    }

    @EventSourcingHandler
    public void on(ProductCreatedEvent event) {
        this.id = event.getId();
        this.product = event.getProduct();
    }

}
