package com.patientdata;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String name = request.getParameter("name");
		String birthdate = request.getParameter("bdate");
		String bloodgroup = request.getParameter("bgroup");
		String gender = request.getParameter("gender");
		String contact_number = request.getParameter("number");
		String address = request.getParameter("address");
		
		Patient p = new Patient();
		p.set_name(name);
		p.set_birthdate(birthdate);
		p.set_bloodgroup(bloodgroup);
		p.set_gender(gender);
		p.set_cntnumber(contact_number);
		p.set_address(address);
		
		int status = PatientDao.save(p);
		if(status>0)
		{
			pw.print("Record Saved Successfully!");
			request.getRequestDispatcher("index.html").include(request, response);
		}
		else
		{
			pw.print("Sorry!Record is not saved.");
		}
		pw.close();
	}

}
