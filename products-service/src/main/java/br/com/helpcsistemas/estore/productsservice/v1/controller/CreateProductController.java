package br.com.helpcsistemas.estore.productsservice.v1.controller;

import br.com.helpcsistemas.estore.productsservice.v1.command.CreateProductCommand;
import jakarta.validation.Valid;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("estore/v1/products")
public class CreateProductController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final CommandGateway commandGateway;

    public CreateProductController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public ResponseEntity<String> createProduct(@Valid @RequestBody CreateProductCommand command) {

        String id = UUID.randomUUID().toString();
        command.setId(id);

        String message = null;

        try {
            message = commandGateway.sendAndWait(command);
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }

        return new ResponseEntity<>("The Product has created as success. Message: "+message, HttpStatus.CREATED); }

}
