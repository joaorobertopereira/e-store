package br.com.helpcsistemas.estore.productsservice.v1.controller;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("estore/v1/products")
public class SearchProductController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final CommandGateway commandGateway;

    public SearchProductController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @GetMapping
    public ResponseEntity<String> getProducts() { return new ResponseEntity<>("Get a List of Products", HttpStatus.OK); }

}
