package server;

import java.util.*;

public class Server {
  
	private ArrayList<UserAccount>users = new ArrayList<UserAccount>();
    private AccessType accesstype;
	


	public AccessType getAccesstype() {
		return accesstype;
	}
	public void setAccesstype(AccessType accesstype) {
		this.accesstype = accesstype;
	}
	public void setUsers(ArrayList<UserAccount> users) {
		this.users = users;
	}
	public ArrayList<UserAccount> getUsers() {
		return users;
	}

	
	public Server() {
		super();
		this.users = new ArrayList<UserAccount>();
		this.accesstype =null;
	}


	public void addUser(UserAccount u){
		this.getUsers().add(u);
	}
	
	private UserAccount findUser(String userName) throws Exception{
		for(UserAccount u : this.getUsers()){
			if (u.getUserAccount().getUserName().equals(userName)){
				return u;		
			}
		}
      	throw new Exception ("User doesn't exist");
	
	}
	
	public ArrayList<Email> sendEmail(String user, AccessType ac) throws Exception{
		
		UserAccount u = this.findUser(user);
		return ac.sendUserEmail(u);
		
		
		
	}
	
	

 

}


