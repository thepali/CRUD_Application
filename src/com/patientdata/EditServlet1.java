package com.patientdata;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		  response.setContentType("text/html");  
	      PrintWriter pw = response.getWriter();  
	      
	      pw.println("<h2>Update Employee</h2>"); 
	      
	      String pid=request.getParameter("id");  
	      int id=Integer.parseInt(pid);  
	          
	      Patient p = PatientDao.getPatientById(id);
	      pw.print("<form action='EditServlet2' method='post'>");
	      pw.print("<table>");
	      pw.print("<tr><td></td><td><input type='hidden' name='id' value='"+p.get_id()+"'/></td></tr>");
	      
	      pw.print("<tr><td>Name :</td><td><input type='text' name='name' value='"+p.get_name()+"'/></td></tr>");
	      
	      pw.print("<tr><td>Birth Date :</td><td><input type='date' name='bdate' value='"+p.get_birthdate()+"'/></td></tr>");
	      
	      pw.print("<tr><td>Blood Group :</td><td>");
	      pw.print("<select name='bgroup' style='width:120px'>");
	      pw.print("<option value=''>choose here</option>");
	      pw.print("<option>A+</option>");
	      pw.print("<option>A-</option>");
	      pw.print("<option>B+</option>");
	      pw.print("<option>B-</option>");
	      pw.print("<option>O+</option>");
	      pw.print("<option>O-</option>");
	      pw.print("<option>AB+</option>");
	      pw.print("<option>AB-</option>");
	      pw.print("</select>");
	      pw.print("</td></tr>");
	      
	      pw.print("<tr><td>Gender :</td><td><input type='text' name='gender' value='"+p.get_gender()+"'/></td></tr>");
	      
	      pw.print("<tr><td>Contact Number :</td><td><input type='text' name='number' value='"+p.get_cntnumber()+"'/></td></tr>");
	      
	      pw.print("<tr><td>Address :</td><td><input type='text' name='address' value='"+p.get_address()+"'/></td></tr>");
	      
	      pw.print("<tr><td colspan='2'><input type='submit' value='Edit & Save' /></td></tr>");
	      pw.print("</table>");
	      pw.print("</form>");
	      
	      pw.close();
	}

}
