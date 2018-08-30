package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Employee;
import com.DAO.EmployeeDAO;;

/**
 * Servlet implementation class SearchByNameServlet
 */
@WebServlet("/SearchByNameServlet")
/**
 * Servlet for search employee by name
 * @author Rachna Jadam
 */
public class SearchByNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchByNameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("search");
		EmployeeDAO queryToShowEmployeeByName = new EmployeeDAO();
		List<Employee> employeeList = queryToShowEmployeeByName.getEmployeesByName(name);
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>"+
        			    "<head>"+
        				    "<title>Employee List</title>"+
        				    "<style>"+
    				            "td,th{text-align: left;padding : 10px;}"+
    				        "</style>"+
        			     "</head>"+
        				 "<body>"+
        			         "<div align='center' style='margin-top: 50px'>"+
        				         "<h1>Search By Name Result</h1>"+
        				 	     "<table>"+
        			         	     "<tr>"+
        				 	             "<th>ID</th>"+
        			         	         "<th>First Name</th>"+
        				 	             "<th>Last Name</th>"+
        			         	         "<th>Email Id</th>"+
        				 	             "<th>Age</th>"+
        			         	     "</tr>");
        for (Employee employee : employeeList) {
        	out.write("<tr id = "+employee.getId()+">"+
        		"<td>"+employee.getId()+"</td>"+
                "<td>"+employee.getFirstName()+"</td>"+
                "<td>"+employee.getLastName()+"</td>"+
                "<td>"+employee.getEmailId()+"</td>"+
                "<td>"+employee.getAge()+"</td></tr>");
        }
        out.println("</body> </html>");
	}
}
