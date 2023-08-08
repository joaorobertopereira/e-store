package br.com.helpcsistemas.estore.productsservice.v1.interceptor;

import org.axonframework.commandhandling.CommandMessage;
import org.axonframework.messaging.MessageDispatchInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.BiFunction;

@Component
public class CreateProductInterceptor implements MessageDispatchInterceptor<CommandMessage<?>> {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Override
    public BiFunction<Integer, CommandMessage<?>, CommandMessage<?>> handle(List<? extends CommandMessage<?>> list) {
        return (index, command) -> {
            log.info("Creating Product ...");
            return command;
        };
    }
}
