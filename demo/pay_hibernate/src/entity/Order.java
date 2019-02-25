package entity;

public class Order {
	private String order_id;
	private Integer product_id;
	private String product_name;
	private Double product_price;
	private Admin admin;
	
	public Order() {}

	public Order(String order_id, Integer product_id, String product_name, Double product_price, Admin admin) {
		super();
		this.order_id = order_id;
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_price = product_price;
		this.admin = admin;
	}
	
	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public Double getProduct_price() {
		return product_price;
	}

	public void setProduct_price(Double product_price) {
		this.product_price = product_price;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", product_id=" + product_id + ", product_name=" + product_name
				+ ", product_price=" + product_price + "]";
	}
	
	
	
	
}
