package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.CustomException.NotValidEmployeeException;
import com.controller.EmployeeController;
import com.model.Employee;

/**
 * Servlet implementation class FriendProfileServlet
 */
@WebServlet("/FriendProfileServlet")
public class FriendProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FriendProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		EmployeeController employeeController = new EmployeeController();
		System.out.println(request.getParameter("employeeID")+request.getParameter("employeeName"));
		int id = Integer.parseInt(request.getParameter("employeeID"));
		String name = request.getParameter("employeeName");
		Employee employee = employeeController.getEmployeeyId(id);
		out.print("<!DOCTYPE html>" + "<html>" +"<head>" + "<title>Edit Profile</title>" +
				"<link rel = 'stylesheet' href = 'style/profile.css' />" + "</head> <body>");
				out.print("<h1 align = 'center'> employee Profile </h1>" + "<table>");
				out.print("<div><table width = '75%'><tr><td><IMG SRC='Capture.PNG' WIDTH='30PX'></TD><TD ALIGN='RIGHT'>");
				out.print("Welcome" + " " +  "<A HREF='#' >Image</A>" + "<A HREF='#'' >" + name +"</A>" +
						   "<A HREF='./ProfileSrevlet?emailId="+employee.getEmailId()+"'>Home</A>" +
						"<A HREF='#'>Logout</A></TD></TR></TABLE><HR/></DIV>");

				out.print("<form><table>");
				       out.print("<tr>" + 
				"<td id = 'label'>First Name</td>" + "<td> <input type = 'text' name='firstName' "
				       		+ "id = 'firstName' value = '"+ employee.getFirstName() +"' disabled = 'true'> </td>" + "</tr>");
				       out.print("<tr>" + "<td id = 'label'>Last Name</td>" + "<td> <input type = 'text' name='lastName' required = 'required'"
				       		+ " id = 'lastName' value = '"+ employee.getLastName() +"' disabled = 'disabled'/></td> </tr>");
				       out.print("<tr>" + "<td id = 'label'>Email</td>" + "<td> <input type = 'text' name='email' required = 'required' id = 'email' "
				       		+ "value = '"+ employee.getEmailId() +"' disabled = 'disabled'/></td> </tr>");
				       out.print("<tr>" + "<td id = 'label'>DOB</td>" + "<td> <input type = 'date' name='dob' required = 'required' id = 'dob' value = '"+ 
				       		employee.getDateOfBirth() +"' disabled = 'disabled'/></td> </tr>");
				out.print("<tr>" + "<td id = 'label'>Contact Number</td>" + "<td> <input type = 'number' name='contactNumber' required = 'required' "
						+ "id = 'contactNumber' value = '"+ employee.getContactNumber() +"' disabled = 'disabled'/></td> </tr>");
		String companyName = employeeController.getEmployeeCompanyNameByCompanyId(employee.getCompanyId());
		out.print("<tr>" + "<td id = 'label'>Company Name</td>" + "<td> <input type = 'text' name='companyName' required = 'required' "
				+ "id = 'companyName' value = '"+ companyName +"' disabled = 'disabled'/></td> </tr>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
