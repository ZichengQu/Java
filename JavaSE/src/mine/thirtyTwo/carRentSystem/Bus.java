package mine.thirtyTwo.carRentSystem;

public class Bus extends Vehicle{
	
	public static final double THREE_DAY = 0.9;
	public static final double SEVEN_DAY = 0.8;
	public static final double THIRTY_DAY = 0.7;
	public static final double ONE_HUNDRED_FIFTY_DAY = 0.6;
	
	private int seatCount;
	
	public Bus(String infor, String number, int moneyPerDay, int seatCount) {
		super(infor, number, moneyPerDay);
		this.seatCount = seatCount;
	}

	public int getSeatCount() {
		return seatCount;
	}

	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}

	@Override
	public int discount() {
		int dayAmount = getDayAmount();
		int totalMoney = getMoneyPerDay()*dayAmount;
		if(dayAmount>3&&dayAmount<=7){
			totalMoney *= THREE_DAY;
		}else if(dayAmount>7&&dayAmount<=30){
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
		return "Bus [infor=" + getInfor() + ", number=" + getNumber() + ", moneyPerDay=" + getMoneyPerDay() + ", dayAmount="
				+ getDayAmount() + "seatCount=" + seatCount + "]";
	}
	
	
}
