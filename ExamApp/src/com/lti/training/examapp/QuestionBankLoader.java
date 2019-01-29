package com.lti.training.examapp;

import java.util.*;

public class QuestionBankLoader {
	
private QuestionBank questionBank;

public QuestionBankLoader()
{
	questionBank=new QuestionBank();
}

public List<Question> loadQuestionsOnJava()
{
	questionBank.addNewSubject("Java");
	
	Question q=new Question();
	q.setQuestion("What is a class?");
	List<Option> options=new ArrayList<>();
	Option o1=new Option("Class is a template",false);
	Option o2=new Option("Class is a blueprint",true);
	Option o3=new Option("Class is a datatype",false);
	Option o4=new Option("Class is a class",false);
	options.add(o1);
	options.add(o2);
	options.add(o3);
	options.add(o4);
	q.setOptions(options);
	questionBank.addNewQuestion("Java", q);
	
	q=new Question();
	q.setQuestion("What is an object?");
	options=new ArrayList<>();
	 o1=new Option("Object is an instance of a class",true);
	 o2=new Option("Object is a part of class",false);
	 o3=new Option("Object is a datatype ",false);
	 o4=new Option("Object is a class",false);
	options.add(o1);
	options.add(o2);
	options.add(o3);
	options.add(o4);
	q.setOptions(options);
	questionBank.addNewQuestion("Java", q);
	
	q=new Question();
	q.setQuestion("What is a instance variable?");
	options=new ArrayList<>();
	 o1=new Option("It is a datatype",false);
	 o2=new Option("It is a part of class",false);
	 o3=new Option("It is a class variable",true);
	 o4=new Option("It is a global variable",false);
	options.add(o1);
	options.add(o2);
	options.add(o3);
	options.add(o4);
	q.setOptions(options);
	questionBank.addNewQuestion("Java", q);
	
	q=new Question();
	q.setQuestion("What is an interface?");
	options=new ArrayList<>();
	 o1=new Option("It is a datatype",false);
	 o2=new Option("It is a part of class",false);
	 o3=new Option("It is an agreement",true);
	 o4=new Option("It is a global variable",false);
	options.add(o1);
	options.add(o2);
	options.add(o3);
	options.add(o4);
	q.setOptions(options);
	questionBank.addNewQuestion("Java", q);
	
	q=new Question();
	q.setQuestion("Which of the following is object oriented programming concept?");
	options=new ArrayList<>();
	 o1=new Option("Procedure",false);
	 o2=new Option("Thread",false);
	 o3=new Option("Polymorphism",true);
	 o4=new Option("Garbage Collection",false);
	options.add(o1);
	options.add(o2);
	options.add(o3);
	options.add(o4);
	q.setOptions(options);
	questionBank.addNewQuestion("Java", q);
	
	return questionBank.getQuestionsFor("Java");
}

}
