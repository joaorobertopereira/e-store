package br.com.helpcsistemas.estore.productsservice.v1.controller;

import br.com.helpcsistemas.estore.productsservice.v1.command.DeleteProductCommand;
import br.com.helpcsistemas.estore.productsservice.v1.dto.ResponseMessage;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("estore/v1/products")
public class DeleteProductController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final CommandGateway commandGateway;

    public DeleteProductController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ResponseMessage> deleteProduct(@PathVariable(value = "id") String id) {

        DeleteProductCommand command = DeleteProductCommand.builder()
                .id(id).build();

        ResponseMessage responseMessage = null;
        try {

            commandGateway.sendAndWait(command);
            responseMessage = ResponseMessage.builder()
                    .code(HttpStatus.OK.value())
                    .message("The Product has updated as success.").build();
        } catch (Exception ex) {
            log.error(ex.getMessage());
            responseMessage = ResponseMessage.builder()
                    .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .message(ex.getMessage()).build();
            return new ResponseEntity<>(responseMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

}
