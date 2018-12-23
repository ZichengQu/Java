package mine.twelve.hero;

public abstract class Hero {
	private String name;
	private double gongJiLi; //¹¥»÷Á¦
	private double fangYuLi; //·ÀÓùÁ¦
	private int price;
	
	public Hero() {
		
	}

	public Hero(String name, double gongJiLi, double fangYuLi, int price) {
		this.name = name;
		this.gongJiLi = gongJiLi;
		this.fangYuLi = fangYuLi;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getGongJiLi() {
		return gongJiLi;
	}

	public void setGongJiLi(double gongJiLi) {
		this.gongJiLi = gongJiLi;
	}

	public double getFangYuLi() {
		return fangYuLi;
	}

	public void setFangYuLi(double fangYuLi) {
		this.fangYuLi = fangYuLi;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}	
	
	public String show(){
		return "Hero [getName()=" + getName() + ", getGongJiLi()=" + getGongJiLi() + ", getFangYuLi()=" + getFangYuLi()
				+ ", getPrice()=" + getPrice() + ", hero()=" + hero() + "]";
	}

	public abstract double hero();
}
