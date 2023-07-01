package spring.project.product.servicesImpl;

import java.util.List;
import java.util.Optional;

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


	@Override
	public List<Product> getAllProducts() {
		List<Product> products = (List<Product>)productRepository.findAll();
		return products;
	}


	@Override
	public void DeleteAllProducts() {

		productRepository.deleteAll();
	}

	   @Override
	    public void editProduct(Long productId, Product updatedProduct) {
	        Optional<Product> existingProductOptional = productRepository.findById(productId);
	        if (existingProductOptional.isPresent()) {
	            Product existingProduct = existingProductOptional.get();
	            existingProduct.setProductName(updatedProduct.getProductName());

	            productRepository.save(existingProduct);
	        } 
	    }


	   @Override
	    public void deleteProduct(Long productId) {
	        productRepository.deleteById(productId);
	    }



}
