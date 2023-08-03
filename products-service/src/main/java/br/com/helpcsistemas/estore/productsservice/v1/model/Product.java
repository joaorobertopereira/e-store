package br.com.helpcsistemas.estore.productsservice.v1.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@DynamoDBTable(tableName = "products")
public class Product implements Serializable {

    @DynamoDBHashKey(attributeName = "id")
    private String id;
    @DynamoDBAttribute(attributeName = "title")
    @NotNull(message = "Title must be not null")
    private String title;
    @DynamoDBAttribute(attributeName = "price")
    @NotNull(message = "Price must be not null")
    private BigDecimal price;
    @DynamoDBAttribute(attributeName = "quantity")
    @NotNull(message = "Quantity must be not null")
    private Integer quantity;

}
