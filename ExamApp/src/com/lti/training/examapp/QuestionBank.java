package com.lti.training.examapp;

import java.util.*;

public class QuestionBank {

	private Map<String,List<Question>> questions; //String=Subject,List=List of questions
	
	public QuestionBank()
	{
		questions=new HashMap<>();
	}
	
	public void addNewSubject(String subject)
{
		questions.put(subject, new ArrayList<>());
}

	public void addNewQuestion(String subject,Question quest)
	{
		List<Question> question=questions.get(subject);
		question.add(quest);
	}
	
	public List<Question> getQuestionsFor(String subject){
		return questions.get(subject);
	}
}
