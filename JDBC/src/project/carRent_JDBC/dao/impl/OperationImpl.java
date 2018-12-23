package project.carRent_JDBC.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import project.carRent_JDBC.bean.Bus;
import project.carRent_JDBC.bean.Car;
import project.carRent_JDBC.bean.Truck;
import project.carRent_JDBC.bean.Vehicle;
import project.carRent_JDBC.dao.Operation;
import project.carRent_JDBC.util.DBUtil;

public class OperationImpl implements Operation{	
	
	
	/**
	 * 选择租赁汽车的方法
	 */
	public void choose() {
		Scanner sc = new Scanner(System.in);
		Vehicle v = null;
		System.out.println("*****欢迎光临腾飞汽车租赁公司*****");
		System.out.println("1、轿车\t2、客车\t3、卡车");
		System.out.print("请选择你要租赁的汽车类型：");
		int vType = sc.nextInt();
		String brand = "";
		String type = "";
		int seat = 0;
		int tonnage = 0;
		if(vType==1) {
			System.out.println("请选择你要租赁的轿车品牌：1、别克 2、宝马");
			int carBrand = sc.nextInt();
			if(carBrand==1) {
				brand = "别克";
				System.out.println("请选择你要租赁的汽车类型：1、林荫大道 2、GL8");
				type = (sc.nextInt()==1)?"林荫大道":"GL8";
			}else if(carBrand==2) {
				brand = "宝马";
				System.out.println("请选择你要租赁的汽车类型：1、X6  2、550i");
				type = (sc.nextInt()==1)?"X6":"550i";
			}else {
				System.out.println("没有找到你要租赁的轿车品牌");
			}
		}else if(vType==2) {
			type = "";
			System.out.println("请选择你要租赁的汽车品牌：1、金龙 2、金杯");	
			brand = (sc.nextInt()==1)?"金龙":"金杯";
			System.out.println("请选择你要租赁的汽车座位数：1、16座 2、34座");
			seat = (sc.nextInt()==1)?16:34;
		}else if(vType==3) {
			type = "";
			System.out.println("请选择你要租赁的汽车品牌：1、一汽解放 2、重庆红岩");
			brand = (sc.nextInt()==1)?"一汽解放":"重庆红岩";
			System.out.println("请选择你要租赁的汽车吨位：1、5吨 2、10吨");
			tonnage = (sc.nextInt()==1)?5:10;
		}else {
			System.out.println("没有找到你要租赁的汽车类型");
		}
		v = this.lease(brand, type, seat, tonnage);
		System.out.print("请输入你要租赁的天数：");
		int days = sc.nextInt();
		double money = v.calRent(days);
		System.out.println("分配给您的车牌号是："+v.getVehicleId());
		System.out.println("您需要支付的租金是："+money+"元");
		System.out.println(v);
	}
	
	/**
	 * 租赁汽车方法：得到一个租赁汽车的对象
	 */
	public Vehicle lease(String brand,String type,int seat,int tonnage) {
		Connection conn = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		PreparedStatement ps3 = null;
		ResultSet rs = null;
		int rows1 = 0;
		int rows2 = 0;
		Vehicle v = null;
		String sql1 = null;
		String sql2 = null;
		String sql3 = "insert into rented values (?,?,?,?,?,?)";
		if(type != null) {
			sql1 = "select * from car where type = ?";
			sql2 = "delete from car where type = ?";
		}else if(seat != 0) {
			sql1 = "select * from bus where seat = ?";
			sql2 = "delete from bus where seat = ?";
		}else if (tonnage != 0) {
			sql1 = "select * from truck where tonnage = ?";
			sql2 = "delete from truck where tonnage = ?";
		}
		try {
			conn = DBUtil.getConnection();
			ps1 = conn.prepareStatement(sql1);
			ps2 = conn.prepareStatement(sql2);
			ps3 = conn.prepareStatement(sql3);
			if(type != null) {
				ps1.setString(1, type);
				ps2.setString(1, type);
			}else if(seat != 0) {
				ps1.setInt(1, seat);
				ps2.setInt(1, seat);
			}else if (tonnage != 0) {
				ps1.setInt(1, tonnage);
				ps2.setInt(1, tonnage);
			}
			rs = ps1.executeQuery();
					
			conn.setAutoCommit(false);
			while (rs.next()) {
				String vehicleId = rs.getString("vehicleId");
			    int perRent = rs.getInt("perRent");
			    
			    ps3.setString(1, brand);
				ps3.setString(2, vehicleId);
				ps3.setInt(3, perRent);
				ps3.setString(4, type);
				ps3.setInt(5, seat);
				ps3.setInt(6, tonnage);
				
				if(type != null) {
					v = new Car(brand, vehicleId, perRent, type);
					ps2.executeUpdate();
					ps3.executeUpdate();
				}else if(seat != 0) {
					v = new Bus(brand, vehicleId, perRent, seat);
					ps2.executeUpdate();
					ps3.executeUpdate();
				}else if (tonnage != 0) {
					v = new Truck(brand, vehicleId, perRent, tonnage);
					ps2.executeUpdate();
					ps3.executeUpdate();
				}
			}
			conn.commit();			
			
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {				
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, ps1, ps2, ps3, rs);
		}
		return v;
	}
	
}