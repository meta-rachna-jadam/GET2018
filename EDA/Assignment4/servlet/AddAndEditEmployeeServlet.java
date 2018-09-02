package com.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.CustomException.NotValidEmployeeException;
import com.model.Employee;

import com.controller.EmployeeController;

/**
 * Servlet implementation class AddAndEditEmployeeServlet
 */
@WebServlet("/AddAndEditEmployeeServlet")
public class AddAndEditEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    public AddAndEditEmployeeServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
        String queryType = request.getParameter("queryType");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String emailId = request.getParameter("emailId");
        String password = request.getParameter("password");
        String contactNumber = request.getParameter("contactNumber");
        int companyId = Integer.parseInt(request.getParameter("companyId"));
        int age = Integer.parseInt(request.getParameter("age"));
        Date dateOfBirth = null;
        EmployeeController employeeController = new EmployeeController();
        try {
			dateOfBirth = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dateOfBirth"));
		} catch (ParseException parseException) {
			parseException.printStackTrace();
		}
        
        Employee employee = null;
		try {
			employee = new Employee(age, firstName, lastName, emailId, password, contactNumber, dateOfBirth, companyId);
		} catch (NotValidEmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        if ("addEmployee".equals(queryType)) {
        	
        	employeeController.createEmployee(employee);
        	response.sendRedirect("./html/login.html");
        } else if ("editEmployee".equals(queryType)) {
        	
        }
    }

}
