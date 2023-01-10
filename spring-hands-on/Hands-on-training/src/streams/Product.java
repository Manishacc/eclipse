package streams;

public class Product {
	int id;
	String name;
	long price;
	
	public Product(int id, String name, long price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public long getPrice() {
		return price;
	}


	public void setPrice(long price) {
		this.price = price;
	}


	public void setName(String name) {
		this.name = name;
	}


	String getName() {
		return this.name;
	}

}
