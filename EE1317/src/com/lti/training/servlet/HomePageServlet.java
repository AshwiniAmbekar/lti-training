package com.lti.training.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.lti.service1.InMemoryUserService;

@WebServlet("/HomePageServlet")
public class HomePageServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body>");
		out.println("<h1>Welcome to abc.com</h1>");
		
		
		String page="Login.html";
		
		//checking if the cookies are present or not
		Cookie[ ] cookies=request.getCookies();
		if(cookies!=null) {
			String username="",password="";
			for(Cookie cookie:cookies) {
				if(cookie.getName().equals("uname"))
					username=cookie.getValue();
				if(cookie.getName().equals("upass"))
					password=cookie.getValue();
				
				/*String userbytes = Base64.getDecoder().decode(username).toString();
				String passbytes = Base64.getDecoder().decode(password).toString();
				
				boolean user=username.equals(userbytes);
				boolean pass=username.equals(passbytes);*/
			}
			
			InMemoryUserService userService=new InMemoryUserService();
			boolean isValid=userService.isValidUser(username, password);
			if(isValid)
				page="welcome.html";
		}
		
		out.println("<a href='" +page+"'>Click here</a>to continue");
		out.println("</body></html>");
		
	}


}
