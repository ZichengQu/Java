package project.carRent_JDBC.bean;

public class Bus extends Vehicle{
	
	//×ùÎ»Êý
	private int seat;
	
	public Bus() {}

	public Bus(String brand, String vehicleId, int perRent,int seat) {
		super(brand, vehicleId, perRent);
		this.seat = seat;
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}

	@Override
	public double calRent(int days) {
		// TODO Auto-generated method stub
		double price = 0;
		if(days>0 && days<3){
			price = this.getPerRent()*days;
		}else if(days>=3 && days<7){
			price = this.getPerRent()*days*0.9;
		}else if(days>=7 && days<30){
			price = this.getPerRent()*days*0.8;
		}else if(days>=30 && days<150){
			price = this.getPerRent()*days*0.7;
		}else{
			price = this.getPerRent()*days*0.6;
		}
		return price;
	}

	@Override
	public String toString() {
		return "Bus [seat=" + seat + ", toString()=" + super.toString() + "]";
	}

	
}
