package spring.project.product.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import spring.project.product.entities.Product;
import spring.project.product.services.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	ProductService productService ;
	@PostMapping("/addProduct")
	@ResponseBody
	
	public void addProduct(	@RequestBody Product product)
	{
		productService.Addproduct(product) ;
	}
	
	@GetMapping("/retrieve-all-products")
	@ResponseBody
	public List<Product> getAllProducts(){
		List<Product> productsList=productService.getAllProducts();
		return productsList;
		
	}
	
	@DeleteMapping("/deleteAllProducts")
	@ResponseBody
	public void deleteAllProducts(){
		productService.DeleteAllProducts() ;
	}
	
	
	@PutMapping("/edit/{productId}")
    public void editProduct(@PathVariable Long productId, @RequestBody Product updatedProduct) {
        productService.editProduct(productId, updatedProduct);
    }
	
	 @DeleteMapping("/delete/{productId}")
	 public void deleteProduct(@PathVariable Long productId) {
	        productService.deleteProduct(productId);
	    }

	

}
