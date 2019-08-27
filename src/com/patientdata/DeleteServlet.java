package com.patientdata;

import java.io.IOException;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String pid=request.getParameter("id");  
        int id=Integer.parseInt(pid);  
        PatientDao.delete(id);  
        response.sendRedirect("ViewServlet");  
        
//		Connection con = PatientDao.getConnection();
//		try 
//		{
//			PreparedStatement ps = con.prepareStatement("select id from patientinfo");
//			ResultSet rs = ps.executeQuery();
//			if(rs.next()) 
//			{
//				int i = rs.getInt("id");
//				System.out.println("The value of id is " + i);
//				PatientDao.delete(i);
//					
//			}
//			response.sendRedirect("ViewServlet");
//		} 
//		catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}

}
