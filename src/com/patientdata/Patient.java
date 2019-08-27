package com.patientdata;

public class Patient {
	private int id;
	private String name;
	private String birthdate;
	private String bloodgroup;
	private String gender;
	private String contact_number;
	private String address;
	
	public void set_id(int id)
	{
		this.id = id;
	}
	
	public void set_name(String name)
	{
		this.name = name;
	}
	
	public void set_birthdate(String birthdate)
	{
		this.birthdate = birthdate;
	}
	
	public void set_bloodgroup(String bloodgroup)
	{
		this.bloodgroup = bloodgroup;
	}
	
	public void set_gender(String gender)
	{
		this.gender = gender;
	}
	
	public void set_cntnumber(String contact_number)
	{
		this.contact_number = contact_number;
	}
	
	public void set_address(String address)
	{
		this.address = address;
	}
	
	public int get_id()
	{
		return id;
	}
	
	public String get_name()
	{
		return name;
	}
	
	public String get_birthdate()
	{
		return birthdate;
	}
	
	public String get_bloodgroup()
	{
		return bloodgroup;
	}
	
	public String get_gender()
	{
		return gender;
	}
	
	public String get_cntnumber()
	{
		return contact_number;
	} 
	
	public String get_address()
	{
		return address;
	}
	
	
}
