package edu.uprm.ece.icom4035.util;

public class MasterListRegisteredUsers {
	
	private static RegisteredUsers<User> registeredUsers;
	
	public static RegisteredUsers<User> getRegisteredUsers(){
		if (registeredUsers == null){
			initialize();
		}
		return registeredUsers;
	}

	private static void initialize() {
		registeredUsers = new RegisteredUsers<User>();
		registeredUsers.addRegisteredUser(new User("Apu", "pr453"));
		registeredUsers.addRegisteredUser(new User("Tom", "tweew"));
		registeredUsers.addRegisteredUser(new User("Lu", "gki$we"));
	}

}
