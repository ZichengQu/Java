package mine.twelve.hero;

public class Assassin extends Hero{
	private double blast;
	
	public Assassin() {
		super();
	}

	public Assassin(String name, double gongJiLi, double fangYuLi, int price, double blast) {
		super(name, gongJiLi, fangYuLi, price);
		this.blast = blast;
	}

	public double getBlast() {
		return blast;
	}

	public void setBlast(double blast) {
		this.blast = blast;
		
		double money = hero();
		if(money>=5000&&money<10000){
			this.blast = this.blast*1002/1000;
		}else if(money>=10000&&money<15000){
			this.blast = this.blast*1004/1000;
		}else if(money>=15000&&money<20000){
			this.blast = this.blast*1006/1000;
		}else if(money>=20000){
			this.blast = this.blast*1008/1000;
		}
	}

	@Override
	public String show() {
		return super.show()+" Assassin [getBlast()=" + getBlast() + ", hero()=" + hero() + "]";
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
