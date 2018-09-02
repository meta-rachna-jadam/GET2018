package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.EmployeeController;
import com.model.Employee;

/**
 * Servlet implementation class FriendServlet
 */
@WebServlet("/FriendServlet")
public class FriendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FriendServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("employeeID"));
		String name = request.getParameter("employeeName");
		EmployeeController employeeController = new EmployeeController();
	    Employee employee = employeeController.getEmployeeyId(id);
		List<Integer> friendIdList = employeeController.getFriendListOfEmployeeById(id);
		PrintWriter out = response.getWriter();
		
		out.print("<!DOCTYPE html>" + "<html>" +"<head>" + "<title>Edit Profile</title>" +
				"<link rel = 'stylesheet' href = 'style/profile.css' />" + "</head> <body>");
				out.print("<h1 align = 'center'> employee Profile </h1>" + "<table>");
				out.print("<div><table width = '75%'><tr><td><IMG SRC='Capture.PNG' WIDTH='30PX'></TD><TD ALIGN='RIGHT'>");
				out.print("Welcome" + " " +  "<A HREF='#' >Image</A>" + "<A HREF='#'' >" + name +"</A>" +
				   "<A HREF='./ProfileSrevlet?emailId="+employee.getEmailId()+"'>Home</A>" +
				"<A HREF='#'>Logout</A></TD></TR></TABLE><HR/></DIV>");

				

		for (Integer friendId : friendIdList) {
			employee = employeeController.getEmployeeyId(friendId);
			System.out.println("friend eid "+employee.getId());
			out.write("<A HREF='./FriendProfileServlet?employeeID="+employee.getId()+"&employeeName="+name+"'>"+employee.getFirstName()+" "+employee.getLastName()+"</A><br/>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
