package spring.project.product.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import spring.project.product.entities.Product;

@CrossOrigin("http://localhost:4200")
public interface productRepository extends CrudRepository<Product , Long> {

}
