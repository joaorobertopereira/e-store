package br.com.helpcsistemas.estore.productsservice.v1.command;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class DeleteProductCommand {
    @TargetAggregateIdentifier
    private String id;
}
