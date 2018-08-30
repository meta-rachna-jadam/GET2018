package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Employee;
import com.DAO.EmployeeDAO;

/**
 * Servlet implementation class UpdateEmployeeServlet
 * Use to show form for update entry of employee
 */
@WebServlet("/UpdateEmployeeServlet")
public class UpdateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateEmployeeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int id = Integer.parseInt(request.getParameter("employeeID"));
		EmployeeDAO selectEmployeById = new EmployeeDAO();
		Employee employee = selectEmployeById.getEmployeeById(id);
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.write("<html>"+
                      "<head>"+
                          "<title>Update Employee Detail</title>"+
                          "<script src='scripts/validation.js'></script>"+
                      "</head>"+
                      "<body>"+
                          "<form action='./AddEmployeeServlet' method='post' id='addEmployeeForm'>"+
                              "<div style='margin-top: 50px' align='center'><h1>Edit Information</h1><table>"+
                                   "<tr><td><span>First Name</span></td>"+
                                        "<td><input type='text' value='"+employee.getFirstName()+"' name='firstName' id='firstName'"+
                                   "onkeyup='validateName(this)' onchange='validateName(this)' /></td></tr>"+
                                   "<tr><td><span>Last Name</span></td>"+
                                        "<td><input type='text' value='"+employee.getLastName()+"' name='lastName' id='lastName'"+
                                   "onkeyup='validateName(this)' onchange='validateName(this)' /></td></tr>"+
                                   "<tr><td><span>Email Id</span></td>"+
                                        "<td><input type='text' value='"+employee.getEmailId()+"' name='emailId' id='emailId'"+
                                   "onkeyup='validateEmail(this)' onchange='validateEmail(this)' /></td></tr>"+
                                   "<tr><td><span>Age</span></td>"+
                                        "<td><input type='number' value='"+employee.getAge()+"' name='age' id='age'"+
                                   "onkeyup='validateAge(this)' onchange='validateAge(this)' /></td></tr>"+
                                   "<tr><td><input type='hidden' value='update' name='queryType'></td></tr>"+
                                   "<tr><td><input type='hidden' value='"+id+"' name='employeeId'></td></tr>"+
                                   "<tr><td><input type='reset' value='Reset'></td>"+
                                        "<td><input type='button' value='Submit' onclick='return validateForm()'></td></tr>");
        out.write("</table></div></body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
