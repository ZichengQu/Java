package entity;

public class Order {
	
	/*--¶©µ¥±í
	create table order_info(

	  order_id  number(30) primary key,
	  product_id      number(30) not null,
	  product_name    varchar2(30) not null,
	  admin_id    number(30) not null

	);
	*/
	private Long order_id;
	private Integer product_id;
	private String product_name;
	private Double product_price;
	private Integer admin_id;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(Long order_id, Integer product_id, String product_name, Double product_price, Integer admin_id) {
		super();
		this.order_id = order_id;
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_price = product_price;
		this.admin_id = admin_id;
	}
	public Long getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Long order_id) {
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
	public Integer getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(Integer admin_id) {
		this.admin_id = admin_id;
	}
	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", product_id=" + product_id + ", product_name=" + product_name
				+ ", product_price=" + product_price + ", admin_id=" + admin_id + "]";
	}
	
}
