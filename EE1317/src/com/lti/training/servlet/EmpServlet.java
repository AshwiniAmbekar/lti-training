package com.lti.training.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/emp.xls")
public class EmpServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/vnd.ms-excel"); //MIME
		PrintWriter out=response.getWriter();
		out.println("Empno\tName\tSalary");
		out.println("1001\tAshwini\t1000");
		out.println("1002\tApurva\t2000");
		out.println("1003\tAshApu\t3000");
		
	}

}
