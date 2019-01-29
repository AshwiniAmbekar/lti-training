package com.training.lti.service1;

import java.util.HashMap;
import java.util.Map;

public class InMemoryUserService {

	private Map<String,String> users;
	
	public InMemoryUserService() {
		users=new HashMap<>();
		users.put("Bob", "123");
		users.put("Alice", "456");
		users.put("Peter", "789");
		users.put("Jack", "101");
		users.put("Valli", "455");
	}
	
	public boolean isValidUser(String username,String password)
	{
		if(users.containsKey(username))
		{
			String pwd=users.get(username);
			if(pwd.equals(password))
				return true;
		}
		return false;	
	}
	

}
