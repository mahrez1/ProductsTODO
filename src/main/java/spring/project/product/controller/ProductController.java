package spring.project.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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

}
