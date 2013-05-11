package edu.uprm.ece.icom4035.util;

import edu.uprm.ece.icom4035.list.LinkedList;
import edu.uprm.ece.icom4035.list.List;

public class RegisteredUsers<E> {
	
	private List<E> users;
	
	public RegisteredUsers(){
		this.users=new LinkedList<E>();
	}
	public boolean isRegisteredUser(E theUser){
		return users.contains(theUser);
	}
	
	public boolean addRegisteredUser(E theUser){
		if(!users.contains(theUser)){
			users.add(theUser);
			return true;
		}
		return false;
	}
	
}
