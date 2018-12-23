package mine.twelve.hero;

public class Shooter extends Hero{
	private double speed;
	
	public Shooter() {
		super();
	}

	public Shooter(String name, double gongJiLi, double fangYuLi, int price, double speed) {
		super(name, gongJiLi, fangYuLi, price);
		this.speed = speed;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
		
		double money = hero();
		if(money>=5000&&money<10000){
			this.speed = this.speed*1002/1000;
		}else if(money>=10000&&money<15000){
			this.speed = this.speed*1004/1000;
		}else if(money>=15000&&money<20000){
			this.speed = this.speed*1006/1000;
		}else if(money>=20000){
			this.speed = this.speed*1008/1000;
		}
	}

	@Override
	public String show() {
		return super.show()+" Shooter [getSpeed()=" + getSpeed() + ", hero()=" + hero() + "]";
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
