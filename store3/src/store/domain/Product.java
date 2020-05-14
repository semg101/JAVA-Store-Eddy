package store.domain;

public class Product {

	private String image;
	private String size;
	private String description;
	private Double price;
	private int id;
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String toString() {
	  StringBuffer buffer = new StringBuffer();
	  buffer.append("Image: " + image + ";");
	  buffer.append("Size: " + size);
	  buffer.append("Description: " + description + ";");
	  buffer.append("Price: " + price);
	  buffer.append("Id: " + id + ";");
	  return buffer.toString();
	}
	
}
