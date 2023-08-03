package br.com.helpcsistemas.estore.productsservice.v1.controller;

import br.com.helpcsistemas.estore.productsservice.v1.command.CreateProductCommand;
import br.com.helpcsistemas.estore.productsservice.v1.model.Product;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("estore/v1/products")
public class UpdateProductController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final CommandGateway commandGateway;

    public UpdateProductController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable(value = "id") String id, @Validated @RequestBody Product product) {

        CreateProductCommand command = CreateProductCommand.builder()
                .id(id)
                .product(product)
                .build();

        String message = null;

        try {
            message = commandGateway.sendAndWait(command);
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }

        return new ResponseEntity<>("The Product has created as success. Message: "+message, HttpStatus.CREATED); }

}
