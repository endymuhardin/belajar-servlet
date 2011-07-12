package me.agung.domain;

import java.util.HashMap;
import java.util.Map;

public class UserList 
{	
	private Map<String,String> userListDetail; // username , password
	private static UserList instance;
	
	public static void init()
	{
		instance = new UserList();	
	}
	
	public static UserList getInstance()
	{		
		return instance;
	}
	
	public boolean validUser(String name, String password)
	{
		if(userListDetail.containsKey(name)) {
			if(userListDetail.get(name).equalsIgnoreCase(password)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	private UserList()
	{
		userListDetail = new HashMap<String,String>();
		
		userListDetail.put("agung", "agung");
		userListDetail.put("bayu", "bayu");
		userListDetail.put("iswara", "iswara");

		for (String key : userListDetail.keySet()) {
			System.out.println("User " + key + " loaded to memory");
		}
	}
}
