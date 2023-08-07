package br.com.helpcsistemas.estore.productsservice.v1.command;

import br.com.helpcsistemas.estore.productsservice.v1.model.Product;
import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class CreateProductCommand {
    @TargetAggregateIdentifier
    private String id;
    @NotNull(message = "Product were supplied")
    @Valid
    private Product product;
}
