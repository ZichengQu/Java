package project.carRent_JDBC.bean;

public class Car extends Vehicle {
	
	//½Î³µÐÍºÅ
	private String type;
	
	public Car() {}

	public Car(String brand, String vehicleId, int perRent,String type) {
		super(brand, vehicleId, perRent);
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public double calRent(int days) {
		// TODO Auto-generated method stub
		double price = 0;
		if(days>0 && days<=7){
			price = this.getPerRent()*days;
		}else if(days>7 && days<=30){
			price = this.getPerRent()*days*0.9;
		}else if(days>30 && days<=150){
			price = this.getPerRent()*days*0.8;
		}else{
			price = this.getPerRent()*days*0.7;
		}
		return price;
	}

	@Override
	public String toString() {
		return "Car [type=" + type + ", toString()=" + super.toString() + "]";
	}
	
	

	


	
	
}
