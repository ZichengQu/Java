package project.carRent_JDBC.bean;

public abstract class Vehicle {
	//����Ʒ��
	private String brand;
	//���ƺ�
	private String vehicleId;
	//�����
	private int perRent;
	
	public Vehicle() {}
	public Vehicle(String brand, String vehicleId, int perRent) {
		super();
		this.brand = brand;
		this.vehicleId = vehicleId;
		this.perRent = perRent;
	}
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}
	public int getPerRent() {
		return perRent;
	}
	public void setPerRent(int perRent) {
		this.perRent = perRent;
	}
	
	public abstract double calRent(int days);
	@Override
	public String toString() {
		return "Vehicle [brand=" + brand + ", vehicleId=" + vehicleId + ", perRent=" + perRent + "]";
	}
	
}
