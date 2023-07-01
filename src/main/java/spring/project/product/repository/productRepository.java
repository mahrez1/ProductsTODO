package spring.project.product.repository;

import org.springframework.data.repository.CrudRepository;

import spring.project.product.entities.Product;

public interface productRepository extends CrudRepository<Product , Long> {

}
