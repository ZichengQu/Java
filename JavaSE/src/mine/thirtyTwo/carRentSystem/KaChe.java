package mine.thirtyTwo.carRentSystem;

public class KaChe extends Vehicle{

	private int heavy;

	public KaChe(String infor, String number, int moneyPerDay, int heavy) {
		super(infor, number, moneyPerDay);
		this.heavy = heavy;
	}

	public int getHeavy() {
		return heavy;
	}

	public void setHeavy(int heavy) {
		this.heavy = heavy;
	}

	@Override
	public int discount() {
		int dayAmount = getDayAmount();
		int totalMoney = getMoneyPerDay()*dayAmount*getHeavy();
	
		return totalMoney;
	}

	@Override
	public String toString() {
		return "KaChe [infor=" + getInfor() + ", number=" + getNumber() + ", moneyPerDay=" + getMoneyPerDay() + ", dayAmount="
				+ getDayAmount() + "heavy=" + heavy + "]";
	}
	
	
}
