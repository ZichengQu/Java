package mine.thirtyTwo.carRentSystem;

public abstract class Vehicle {
	private String infor;
	private String number;
	private int moneyPerDay;
	private int dayAmount;
	
	

	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vehicle(String infor, String number, int moneyPerDay) {
		this.infor = infor;
		this.number = number;
		this.moneyPerDay = moneyPerDay;
	}

	public String getInfor() {
		return infor;
	}

	public void setInfor(String infor) {
		this.infor = infor;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getMoneyPerDay() {
		return moneyPerDay;
	}

	public void setMoneyPerDay(int moneyPerDay) {
		this.moneyPerDay = moneyPerDay;
	}

	public int getDayAmount() {
		return dayAmount;
	}

	public void setDayAmount(int dayAmount) {
		this.dayAmount = dayAmount;
	}
	
	
	@Override
	public String toString() {
		return "Vehicle [infor=" + infor + ", number=" + number + ", moneyPerDay=" + moneyPerDay + ", dayAmount="
				+ dayAmount + "]";
	}

	public abstract int discount();		
}
