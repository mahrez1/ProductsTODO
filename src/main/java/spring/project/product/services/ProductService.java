package spring.project.product.services;

import java.util.List;

import spring.project.product.entities.Product;

public interface ProductService {
	void Addproduct(Product product);
	public List<Product> getAllProducts();
	void DeleteAllProducts() ;
    void editProduct(Long productId, Product updatedProduct);
    void deleteProduct(Long productId);


}
