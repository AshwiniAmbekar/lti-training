package com.lti.training.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/currency.lti")  //html page will call the servlet  by this link
public class CurrencyConverterServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Request part i.e. getting the data from client side
		String from= request.getParameter("from");
		String to= request.getParameter("to");
		double amount=Double.parseDouble(request.getParameter("amount"));
		
		double result = 0;
		if(from.equals("USD") && to.equals("INR"))
			result=amount * 71.71;
		else if(from.equals("INR") && to.equals("USD"))
			result=amount / 72.72;
		
		//Dynamic web page
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body>");
		out.println("<b> " +amount  +" " +from +"="  +result  +" "  +to + "</b>");
		out.println("</body></html>");
		
		
	}

}
