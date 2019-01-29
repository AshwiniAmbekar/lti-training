package com.lti.training.examapp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoadQuestionServlet")
public class LoadQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private int count;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QuestionBankLoader loader=new QuestionBankLoader();
		List<Question> questions=loader.loadQuestionsOnJava();
		
	    HttpSession session=request.getSession();
	    //checking if question no is already stored in the session
	    Integer quesno=(Integer) session.getAttribute("qNo");
	    if(quesno==null)
	    		quesno=0; //start from first question
	    else if(++quesno>=questions.size()) {
	    		response.sendRedirect("displayScore.jsp");
	    		return;
	    }
	    
	     session.setAttribute("qNo", quesno);
	    
		Question question=questions.get(quesno);
		session.setAttribute("currentQs", question);
		
		response.sendRedirect("showQuestion.jsp");
		
	
	}

}
