package mine.twelve.hero;

public class Warrior extends Hero{
	private double blood;	
	
	public Warrior() {
		super();
	}

	public Warrior(String name, double gongJiLi, double fangYuLi, int price, double blood) {
		super(name, gongJiLi, fangYuLi, price);
		this.blood = blood;
	}

	public double getBlood() {
		return blood;
	}

	public void setBlood(double blood) {
		this.blood = blood;
		
		double money = hero();
		if(money>=5000&&money<10000){
			this.blood = this.blood*2;
		}else if(money>=10000&&money<15000){
			this.blood = this.blood*4;
		}else if(money>=15000&&money<20000){
			this.blood = this.blood*6;
		}else if(money>=20000){
			this.blood = this.blood*8;
		}
	}

	@Override
	public String show() {
		return super.show()+" Warrior [getBlood()=" + getBlood() + ", hero()=" + hero() + "]";
	}

	@Override
	public double hero() {
		int money = 0;
		//............
		if(money<5000){
			System.out.println("金币个数不足，请继续积攒");
		}
		return 0;
	}
	
}
