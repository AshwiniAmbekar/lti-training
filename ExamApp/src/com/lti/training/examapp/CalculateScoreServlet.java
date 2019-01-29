package com.lti.training.examapp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CalculateScoreServlet")
public class CalculateScoreServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session=request.getSession();
			Question q=(Question) session.getAttribute("currentQs");
	
			int selectedOptionno=Integer.parseInt(request.getParameter("option"));
			
			Integer score=(Integer) session.getAttribute("score");
			if(score==null)
				score=0;
			
			Option selectedOption=q.getOptions().get(selectedOptionno);
			if(selectedOption.isRightAnswer())
				score++;
			
			session.setAttribute("score", score);
			response.sendRedirect("LoadQuestionServlet");
	}

}
