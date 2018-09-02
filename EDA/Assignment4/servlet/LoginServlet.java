package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.CustomException.SQLDatabaseException;
import com.constants.EmployeeConstants;
import com.constants.ExceptionDBConstants;
import com.controller.EmployeeController;
import com.model.LoginInformation;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        // get request parameters for emailId and password
        String emailId = request.getParameter("emailId");
        String password = request.getParameter("password");
        PrintWriter out = response.getWriter();
        /*if (emailId == null) {
			new SQLDatabaseException("LoginServlet", "Get Null in email id", "Get Null in email id through login page");
        } else if (password == null) {
        	new SQLDatabaseException("LoginServlet", "Get Null in email id", "Get Null in email id through login page");
        }*/
        
        LoginInformation loginInformation = new EmployeeController().validateLoginInformation(emailId);
        if(loginInformation == null){
        	System.out.println("null");
        }else{
        	System.out.println("not null");
        }
        try {
			if (emailId.equals(loginInformation.getEmailId()) && password.equals(loginInformation.getPassword())) {
			    //get the old session and invalidate
			    HttpSession oldSession = request.getSession(false);
			    if (oldSession != null) {
			        oldSession.invalidate();
			    }
			    //generate a new session
			    HttpSession newSession = request.getSession(true);

			    //setting session to expiry in 5 mins
			    
			    //newSession.setMaxInactiveInterval(5*60);
			    
			    //response.sendRedirect("admin/LoginSuccess.jsp");
			    //out.println("<script>alert("+"'email id are correct'"+")</script>");
			    /*request.setAttribute("emailId", emailId);
			    RequestDispatcher requestDispatcher = request.getRequestDispatcher("./ProfileSrevlet");
			    requestDispatcher.forward(request, response);
			    System.out.println("jfbdjbf");*/
			    
			    request.getSession(false).setAttribute("emailId", emailId);
			    response.sendRedirect("./ProfileSrevlet");
			} else {
				System.out.println("if else");
				if(getServletContext() == null){
					System.out.println("NULL");
				}else{ 
					System.out.println("NOT NULL");
				}
				
			    RequestDispatcher rd = request.getRequestDispatcher("index.html");
			    System.out.println("Check point");
			    out.println("<script>alert("+"'either email id or password is invalid'"+")</script>");
			    rd.include(request, response);
			}
		} catch (NullPointerException nullPointerException) {
			System.out.println("NullPointerException");
			out.println("<script>alert("+"'Null in either email id or password'"+")</script>");
			RequestDispatcher requestdispatch = request.getRequestDispatcher("index.html");
			requestdispatch.include(request, response);
		} catch (Exception exception) {
			System.out.println("Exception "+exception.toString());
			out.println("<script>alert("+"Something wrong"+")</script>");
			RequestDispatcher requestdispatch = request.getRequestDispatcher("index.html");
			requestdispatch.include(request, response);
		}
        
    }
}
