package mine.thirtyTwo.carRentSystem;

public class Car extends Vehicle{
	
	public static final double SEVEN_DAY = 0.9;
	public static final double THIRTY_DAY = 0.8;
	public static final double ONE_HUNDRED_FIFTY_DAY = 0.7;
	
	private String attribute;
	
	public Car(String infor, String number, int moneyPerDay, String attribute) {
		super(infor, number, moneyPerDay);
		this.attribute = attribute;
	}
	
	@Override
	public int discount() {
		int dayAmount = getDayAmount();
		int totalMoney = getMoneyPerDay()*dayAmount;
		if(dayAmount>7&&dayAmount<=30){
			totalMoney *= SEVEN_DAY;
		}else if(dayAmount>30&&dayAmount<=150){
			totalMoney *= THIRTY_DAY;
		}else if(dayAmount>150){
			totalMoney *= ONE_HUNDRED_FIFTY_DAY;
		}		
		return totalMoney;
	}

	@Override
	public String toString() {
		return "Car [infor=" + getInfor() + ", number=" + getNumber() + ", moneyPerDay=" + getMoneyPerDay() + ", dayAmount="
				+ getDayAmount() + "attribute=" + attribute + "]";
	}

	
	
	
}
