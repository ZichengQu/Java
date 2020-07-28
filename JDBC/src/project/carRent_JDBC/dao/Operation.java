package project.carRent_JDBC.dao;

import project.carRent_JDBC.bean.Vehicle;

public interface Operation {
	public Vehicle lease(String brand,String type,int seat,int tonnage);
	public void choose();
}
