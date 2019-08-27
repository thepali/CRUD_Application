package com.patientdata;

import java.sql.*;
import java.util.ArrayList;

public class PatientDao {
	//dao - data access object
	public static Connection getConnection()
	{
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/patient_details", "root", "root");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return con;
	}
	
	public static int save(Patient p)
	{
		int status = 0;
		try 
		{
			Connection con = PatientDao.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into patientinfo(name,birth_date,blood_group,gender,contact_number,address) values(?,?,?,?,?,?)");
			ps.setString(1,p.get_name());
			ps.setString(2,p.get_birthdate());
			ps.setString(3,p.get_bloodgroup());
			ps.setString(4,p.get_gender());
			ps.setString(5,p.get_cntnumber());
			ps.setString(6,p.get_address());
			
			status = ps.executeUpdate();
			con.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public static int update(Patient p)
	{
		int status = 0;
		try 
		{
			Connection con = PatientDao.getConnection();
			PreparedStatement ps = con.prepareStatement("update patientinfo set name=?,birth_date=?,blood_group=?,gender=?,contact_number=?,address=? where id=?");
			ps.setString(1,p.get_name());
			ps.setString(2, p.get_birthdate());
			ps.setString(3, p.get_bloodgroup());
			ps.setString(4, p.get_gender());
			ps.setString(5, p.get_cntnumber());
			ps.setString(6, p.get_address());
			ps.setInt(7, p.get_id());
			
			status = ps.executeUpdate();
			con.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public static int delete(int id)
	{
		int status = 0;
		try 
		{
			Connection con = PatientDao.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from patientinfo where id=?");
			ps.setInt(1,id);
			
			status = ps.executeUpdate();
			if(status>0)
			{
				System.out.println("Record Deleted Successfully!");
			}
			
			con.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public static Patient getPatientById(int id)
	{
		Patient p = new Patient();
		
		try {
			Connection con = PatientDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from patientinfo where id=?");
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				p.set_id(rs.getInt(1));
				p.set_name(rs.getString(2));
				p.set_birthdate(rs.getString(3));
				p.set_bloodgroup(rs.getString(4));
				p.set_gender(rs.getString(5));
				p.set_cntnumber(rs.getString(6));
				p.set_address(rs.getString(7));
			}
			con.close();
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return p;
	}
	
	public static ArrayList<Patient> getAllPatientsDetails()
	{
		ArrayList<Patient> list = new ArrayList<Patient>();
		
		try {
			Connection con = PatientDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from patientinfo");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Patient p = new Patient();
				p.set_id(rs.getInt(1));
				p.set_name(rs.getString(2));
				p.set_birthdate(rs.getString(3));
				p.set_bloodgroup(rs.getString(4));
				p.set_gender(rs.getString(5));
				p.set_cntnumber(rs.getString(6));
				p.set_address(rs.getString(7));
				list.add(p);
			}
			con.close();
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return list;
	}
	
}
