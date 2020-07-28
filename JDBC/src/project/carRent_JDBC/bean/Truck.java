package project.carRent_JDBC.bean;

public class Truck extends Vehicle {
	
	//ถึฮป
	private int tonnage;
	
	public Truck() {}

	public Truck(String brand, String vehicleId, int perRent,int tonnage) {
		super(brand, vehicleId, perRent);
		this.tonnage = tonnage;
	}

	public int getTonnage() {
		return tonnage;
	}

	public void setTonnage(int tonnage) {
		this.tonnage = tonnage;
	}

	@Override
	public double calRent(int days) {
		// TODO Auto-generated method stub
		return tonnage*days*50;
	}

	@Override
	public String toString() {
		return "Truck [tonnage=" + tonnage + ", toString()=" + super.toString() + "]";
	}
	
}
