package com.patientdata;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		pw.println("<a href='index.html'>Add New Patient Details</a>");
		pw.println("<h3>Patients List</h3>");
		
		ArrayList<Patient> list = PatientDao.getAllPatientsDetails();
		
		pw.print("<table border='1' width='100%'>");
		pw.print("<tr>");
		pw.print("<th>Id</th>");
		pw.print("<th>Name</th>");
		pw.print("<th>Birth_Date</th>");
		pw.print("<th>Blood_Group</th>");
		pw.print("<th>Gender</th>");
		pw.print("<th>Contact_Number</th>");
		pw.print("<th>Address</th>");
		pw.print("<th>Edit</th>");
		pw.print("<th>Delete</th>");
		pw.print("</tr>");
		
		for(Patient p:list)
		{
			pw.print("<tr>");
			pw.print("<td>"+p.get_id()+"</td>");
			pw.print("<td>"+p.get_name()+"</td>");
			pw.print("<td>"+p.get_birthdate()+"</td>");
			pw.print("<td>"+p.get_bloodgroup()+"</td>");
			pw.print("<td>"+p.get_gender()+"</td>");
			pw.print("<td>"+p.get_cntnumber()+"</td>");
			pw.print("<td>"+p.get_address()+"</td>");
			int x=p.get_id();
			pw.print("<td><a href='EditServlet1?id="+x+"'>edit</a></td>");
			pw.print("<td><a href='DeleteServlet?id="+x+"'>delete</a></td>");
			pw.print("</tr>");
		}
		pw.print("</table>");
		pw.close();
	}
}
