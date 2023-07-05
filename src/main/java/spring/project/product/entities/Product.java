package spring.project.product.entities;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long ID ;
	String productName ;
	int quantity ;
	boolean available ;
	private String imageUrl;
	
	
	
	public Product() {
		super();
	}
	public Product(long ID, String productName, int quantity, boolean available, String imageUrl) {
		super();
		this.ID = ID;
		this.productName = productName;
		this.quantity = quantity;
		this.available = available;
        this.imageUrl = imageUrl;

	}
	public long getID() {
		return ID;
	}
	public void setID(long ID) {
		this.ID = ID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
	

}
