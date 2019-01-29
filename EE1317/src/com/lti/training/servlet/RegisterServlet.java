package com.lti.training.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.lti.service1.LoginDao;

@WebServlet("/registerpage")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//collecting the request/form data
	   String name=request.getParameter("name");
	   String address=request.getParameter("address");
	   String email=request.getParameter("email");
	   
	   LoginDao l=new LoginDao();
	   l.newUser(name, address, email);
	   System.out.println("Data printed");
	     
	}

}
