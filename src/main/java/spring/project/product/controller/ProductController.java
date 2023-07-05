package spring.project.product.controller;

import java.io.IOException;


import org.springframework.http.MediaType;

import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import spring.project.product.entities.Product;
import spring.project.product.services.ProductService;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.gson.Gson;

import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import jakarta.servlet.annotation.MultipartConfig;
@MultipartConfig
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/product")
public class ProductController {
	
	private final Storage firebaseStorage;

	@Autowired
	public ProductController() {
	    // Initialize the Storage object
	    try {
	        InputStream serviceAccountKey = getClass().getResourceAsStream("/credentials/producttodo-cd8ff-firebase-adminsdk-ml891-35a20472a7.json");
	        GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccountKey);
	        StorageOptions options = StorageOptions.newBuilder().setCredentials(credentials).build();
	        this.firebaseStorage = options.getService();
	    } catch (IOException e) {
	        throw new IllegalStateException("Failed to initialize Firebase Storage", e);
	    }
	}
	    
	@Autowired
	ProductService productService ;
	
	@PostMapping(value = "/addProduct", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseBody
	public void addProduct(@RequestPart("product") String productJson,
	                       @RequestPart("imageUrl") MultipartFile imageFile,
	                       MultipartHttpServletRequest request) {
	    Product product = new Gson().fromJson(productJson, Product.class);
	    
	    if (!imageFile.isEmpty()) {
	        String imageUrl = uploadImageToFirebase(imageFile);
	        product.setImageUrl(imageUrl);
	    }
	    
	    // Process the files and save the product
	    // Handle the product file if necessary
	    
	    productService.Addproduct(product);
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
	 
	public String uploadImageToFirebase(MultipartFile file) {
	    String filename = UUID.randomUUID().toString() + "-" + file.getOriginalFilename();

	    try (InputStream inputStream = file.getInputStream()) {
	        String folderName = "products";
	        String objectName = folderName + "/" + filename;

	        String imageUrl = "https://firebasestorage.googleapis.com/v0/b/" +
	                "producttodo-cd8ff.appspot.com" + 
	                "/o/" + objectName + "?alt=media";

	        BlobId blobId = BlobId.of("producttodo-cd8ff.appspot.com", objectName);
	        BlobInfo blobInfo = BlobInfo.newBuilder(blobId)
	                .setContentType(file.getContentType())
	                .build();

	        Blob blob = firebaseStorage.create(blobInfo, inputStream);

	        return imageUrl;
	    } catch (IOException e) {
	        throw new IllegalStateException("Failed to upload image to Firebase Storage", e);
	    }
	}

}
