package com.lti.training.servlet;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.lti.service1.InMemoryUserService;

@WebServlet("/loginpage")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//collecting the request/form data
	   String username=request.getParameter("username");
	   String password=request.getParameter("password");
	   System.out.println(username+password);
	   //checking if the username/password is valid
	   InMemoryUserService us = new InMemoryUserService();
	   boolean isValid= us.isValidUser(username, password);
	   
	   if(isValid) {
		   String rememberMe=request.getParameter("rememberMe");
		   
		   //encoding of username and password
		  /* String base64encodedString = Base64.getEncoder().encodeToString(
		            username.getBytes("utf-8"));
		   String base64encodedString1 = Base64.getEncoder().encodeToString(
		            password.getBytes("utf-8"));*/
		   if(rememberMe!=null && rememberMe.equals("yes")) {
			   Cookie c1=new Cookie("uname",username);
			   Cookie c2=new Cookie("upass",password);
			   c1.setMaxAge(60*60*24);
			   c2.setMaxAge(60*60*24);
			   
			   response.addCookie(c1);
			   response.addCookie(c2);
			   
		   }
			   
		   response.sendRedirect("welcome.html");
	   }
	   else {
		   response.sendRedirect("Login.html");
	   }
	}

  
  
	   
   

}
