package br.com.helpcsistemas.estore.productsservice.v1.controller;

import br.com.helpcsistemas.estore.productsservice.v1.command.CreateProductCommand;
import br.com.helpcsistemas.estore.productsservice.v1.dto.ResponseMessageDto;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
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
    public ResponseEntity<ResponseMessageDto> createProduct(@Valid @RequestBody CreateProductCommand command) {

        String id = UUID.randomUUID().toString();
        command.setId(id);

        ResponseMessageDto responseMessageDto = null;
        try {

            commandGateway.sendAndWait(command);
            responseMessageDto = ResponseMessageDto.builder()
                    .code(HttpStatus.CREATED.value())
                    .message("The Product has created as success.").build();
        } catch (Exception ex) {
            log.error(ex.getMessage());
            responseMessageDto = ResponseMessageDto.builder()
                    .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .message(ex.getMessage()).build();
            return new ResponseEntity<>(responseMessageDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(responseMessageDto, HttpStatus.CREATED);
    }


}
