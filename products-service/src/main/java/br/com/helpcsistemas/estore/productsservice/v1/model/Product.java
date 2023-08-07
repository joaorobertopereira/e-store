package br.com.helpcsistemas.estore.productsservice.v1.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@Document(collection = "products")
public class Product implements Serializable {

    @Id
    private String id;

    @NotNull(message = "Title must be not null")
    private String title;

    @NotNull(message = "Price must be not null")
    private BigDecimal price;

    @NotNull(message = "Quantity must be not null")
    private Integer quantity;

}
