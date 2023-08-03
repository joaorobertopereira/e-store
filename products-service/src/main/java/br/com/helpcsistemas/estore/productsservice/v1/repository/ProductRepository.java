package br.com.helpcsistemas.estore.productsservice.v1.repository;

import br.com.helpcsistemas.estore.productsservice.v1.model.Product;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@EnableScan
public interface ProductRepository extends CrudRepository<Product, String> {

}
