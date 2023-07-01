package spring.project.product.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.project.product.entities.Product;
import spring.project.product.services.ProductService;
import spring.project.product.repository.*;

@Service
public class ProductServiceImpl  implements ProductService {

	@Autowired
	 productRepository productRepository ;
	
	
	@Override
	public void Addproduct(Product product) {
		productRepository.save(product) ;
	}



}
