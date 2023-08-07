package br.com.helpcsistemas.estore.productsservice.v1.repository;

import br.com.helpcsistemas.estore.productsservice.v1.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

}
