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
	 * ѡ�����������ķ���
	 */
	public void choose() {
		Scanner sc = new Scanner(System.in);
		Vehicle v = null;
		System.out.println("*****��ӭ�����ڷ��������޹�˾*****");
		System.out.println("1���γ�\t2���ͳ�\t3������");
		System.out.print("��ѡ����Ҫ���޵��������ͣ�");
		int vType = sc.nextInt();
		String brand = "";
		String type = "";
		int seat = 0;
		int tonnage = 0;
		if(vType==1) {
			System.out.println("��ѡ����Ҫ���޵Ľγ�Ʒ�ƣ�1����� 2������");
			int carBrand = sc.nextInt();
			if(carBrand==1) {
				brand = "���";
				System.out.println("��ѡ����Ҫ���޵��������ͣ�1�������� 2��GL8");
				type = (sc.nextInt()==1)?"������":"GL8";
			}else if(carBrand==2) {
				brand = "����";
				System.out.println("��ѡ����Ҫ���޵��������ͣ�1��X6  2��550i");
				type = (sc.nextInt()==1)?"X6":"550i";
			}else {
				System.out.println("û���ҵ���Ҫ���޵Ľγ�Ʒ��");
			}
		}else if(vType==2) {
			type = "";
			System.out.println("��ѡ����Ҫ���޵�����Ʒ�ƣ�1������ 2����");	
			brand = (sc.nextInt()==1)?"����":"��";
			System.out.println("��ѡ����Ҫ���޵�������λ����1��16�� 2��34��");
			seat = (sc.nextInt()==1)?16:34;
		}else if(vType==3) {
			type = "";
			System.out.println("��ѡ����Ҫ���޵�����Ʒ�ƣ�1��һ����� 2���������");
			brand = (sc.nextInt()==1)?"һ�����":"�������";
			System.out.println("��ѡ����Ҫ���޵�������λ��1��5�� 2��10��");
			tonnage = (sc.nextInt()==1)?5:10;
		}else {
			System.out.println("û���ҵ���Ҫ���޵���������");
		}
		v = this.lease(brand, type, seat, tonnage);
		System.out.print("��������Ҫ���޵�������");
		int days = sc.nextInt();
		double money = v.calRent(days);
		System.out.println("��������ĳ��ƺ��ǣ�"+v.getVehicleId());
		System.out.println("����Ҫ֧��������ǣ�"+money+"Ԫ");
		System.out.println(v);
	}
	
	/**
	 * ���������������õ�һ�����������Ķ���
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