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
import com.DAO.EmployeeDAO;

/**
 * Servlet implementation class ShowAllEmployeeServlet
 * Use to show all employee in table form
 * @author Rachna Jadam
 */
@WebServlet("/ShowAllEmployeeServlet")
public class ShowAllEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShowAllEmployeeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EmployeeDAO queryToShowAllEmployee = new EmployeeDAO();
		List<Employee> employeeList = queryToShowAllEmployee.getAllEmployee();
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
        				     "<h1>Employee List</h1>"+
        				 	     "<table>"+
        			         	     "<tr>"+
        				 	             "<th>ID</th>"+
        			         	         "<th>First Name</th>"+
        				 	             "<th>Last Name</th>"+
        			         	         "<th>Email Id</th>"+
        				 	             "<th>Age</th>"+
        			         	         "<th>Update</th>"+
        			         	     "</tr>");
        for (Employee employee : employeeList) {
        	out.write("<tr id = "+employee.getId()+">"+
        		"<td>"+employee.getId()+"</td>"+
                "<td>"+employee.getFirstName()+"</td>"+
                "<td>"+employee.getLastName()+"</td>"+
                "<td>"+employee.getEmailId()+"</td>"+
                "<td>"+employee.getAge()+"</td>");
        	out.write("<td align='center'><a href='./UpdateEmployeeServlet?employeeID="+employee.getId()+"'><img width='20px'"+
                      " src='images/update.png' alt='Update' /></a>");
        	/*out.write("<td><form action='./UpdateEmployeeServlet' method='post'>"+
        			      "<input type='hidden' value='"+employee.getId()+"' name='employeeID' />"+
        			      "<input type='submit' value='Update' /></form></td></tr>");*/
        }
        out.println("</table></div></body> </html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
