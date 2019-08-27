package com.patientdata;

import java.io.IOException;

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
		
	}

}
