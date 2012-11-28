package server;

import java.util.*;

import exception.CannotFindUserException;


public class Server {
  
	private ArrayList<UserAccount>users = new ArrayList<UserAccount>();
    
	
	public void setUsers(ArrayList<UserAccount> users) {
		this.users = users;
	}
	public ArrayList<UserAccount> getUsers() {
		return users;
	}

	
	public Server() {
		super();
		this.users = new ArrayList<UserAccount>();
	}


	public void addUser(UserAccount u){
		this.getUsers().add(u);
	}
	

	private ArrayList<ServerEmailHead> headsOfEmails(UserAccount u){
		ArrayList<ServerEmailHead>h = new ArrayList<ServerEmailHead>();
		for (ServerEmail e : u.getUserEmail()){
			h.add(e.getHead());
		}
		return h;
	}
	
	private UserAccount findUser(String userName) throws Exception{
		for(UserAccount u : this.getUsers()){
			if (u.getUserAccount().getUserName() == userName){
				return u;		
			}
		}
      	throw new CannotFindUserException("User doesn't exist");
	
	}
	public ArrayList<ServerEmail> sendEmailWithPOP3(String user, boolean clearList) throws Exception{
		/* send all Email
		 */
		UserAccount u = this.findUser(user);
		if (clearList){
			this.findUser(user).clearList();
		}
		return u.getUserEmail();
		
	}
	
	public ArrayList<ServerEmailHead> sendEmailWithIMAP(String username) throws Exception{
		/* send all Email heads */
		 return    this.headsOfEmails(this.findUser(username));
		      }
	
	public ServerEmail sendEmail(ServerEmailHead h,String userName) throws Exception{
		/* this method must return an Email
		 * only works with IMAP protocol
		 */
		return this.findUser(userName).sendEmailComplete(h);
		
	}
	
	public void reciveAndSend(ServerEmail h) throws Exception{
		/*this method recive an Email and search in the list of users 
		 * if exist, this method will add the Email to the list of Emails from the user
		 */
		this.findUser(h.getHead().getReciver()).getUserEmail().add(h);
	}
	
	public void removeEmailByHeader(String userName , ServerEmailHead h) throws Exception{
		this.findUser(userName).deleteEmailByHeader(h);
	}
	
	public void removeEmailByReader (String userName , ServerEmail h)throws Exception {
		this.findUser(userName).deleteEmailByReader(h);
	}
	
	
}


