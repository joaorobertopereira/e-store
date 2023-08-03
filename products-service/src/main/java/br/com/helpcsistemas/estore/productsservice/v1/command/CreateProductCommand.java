package br.com.helpcsistemas.estore.productsservice.v1.command;

import br.com.helpcsistemas.estore.productsservice.v1.model.Product;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class CreateProductCommand {
    @TargetAggregateIdentifier
    private String id;
    @NotNull(message = "Product were supplied")
    @Valid
    private Product product;
}
