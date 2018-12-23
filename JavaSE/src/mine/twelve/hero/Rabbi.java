package mine.twelve.hero;

public class Rabbi extends Hero{
	private double faLi;//����
	
	public Rabbi() {
		super();
	}
	
	public Rabbi(String name, double gongJiLi, double fangYuLi, int price, double faLi) {
		super(name, gongJiLi, fangYuLi, price);
		this.faLi = faLi;
	}
	
	public double getFaLi() {
		return faLi;
	}

	public void setFaLi(double faLi) {
		this.faLi = faLi;
		
		double money = hero();
		if(money>=5000&&money<10000){
			this.faLi = this.faLi*2;
		}else if(money>=10000&&money<15000){
			this.faLi = this.faLi*4;
		}else if(money>=15000&&money<20000){
			this.faLi = this.faLi*6;
		}else if(money>=20000){
			this.faLi = this.faLi*8;
		}
	}

	@Override
	public String show() {
		return super.show()+" Rabbi [getFaLi()=" + getFaLi() + ", hero()=" + hero() + "]";
	}

	@Override
	public double hero() {
		int money = 0;
		//............
		if(money<5000){
			System.out.println("��Ҹ������㣬���������");
		}
		return 0;
	}
}
