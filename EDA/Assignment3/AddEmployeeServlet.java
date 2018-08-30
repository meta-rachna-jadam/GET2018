package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.constants.EmployeeConstants;
import com.model.Employee;
import com.DAO.EmployeeDAO;;

/**
 * Servlet implementation class AddEmployeeServlet
 * Use to add and update employee in database
 * @author Rachna Jadam
 */
public class AddEmployeeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public AddEmployeeServlet() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		
		String queryType = request.getParameter("queryType");
		String firstName = request.getParameter("firstName").trim();
		String lastName = request.getParameter("lastName").trim();
		String emailId = request.getParameter("emailId").trim();
		int employeeDetailsAddedOrUpdate = -1;
		int age = Integer.parseInt(request.getParameter("age").trim());
		EmployeeDAO EmployeeDAO = new EmployeeDAO();
		Employee employee = new Employee(firstName, lastName, emailId, age);
		if ("add".equals(queryType)) {
			employeeDetailsAddedOrUpdate = EmployeeDAO.addEmployee(employee);
		} else if ("update".equals(queryType)) {
			int id = Integer.parseInt(request.getParameter("employeeId"));
			employeeDetailsAddedOrUpdate = EmployeeDAO.updateEmployeeById(id,employee);
		}
		
		PrintWriter out = response.getWriter();
	       
	    if (employeeDetailsAddedOrUpdate > 0) {
	        out.println("<script>alert("+EmployeeConstants.successful+")</script>");
	    } else if (employeeDetailsAddedOrUpdate == -1) {
	        out.println("<script>alert("+EmployeeConstants.sqlError+")</script>");
	    } else {
	    	out.println("<script>alert("+EmployeeConstants.notSuccessful+")</script>");
	    }
        RequestDispatcher requestdispatch = request.getRequestDispatcher("index.html");
        requestdispatch.include(request, response);
	}

}
