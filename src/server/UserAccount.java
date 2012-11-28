package server;

import java.util.*;

import exception.CannotFindEmailException;


public class UserAccount {
	private ServerUser userAccount;
	private ArrayList<ServerEmail> userEmail;

	public ServerUser getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(ServerUser user) {
		this.userAccount = user;
	}

	public ArrayList<ServerEmail> getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(ArrayList<ServerEmail> userEmail) {
		this.userEmail = userEmail;
	}

	public UserAccount(ServerUser user) {
		super();
		this.userAccount = user;
		// CREATION OF AN EMPTY EMAIL LIST..
		this.userEmail = new ArrayList<ServerEmail>();
	}

	public void clearList() {
		this.getUserEmail().removeAll(this.getUserEmail());
	}

	public ServerEmail sendEmailComplete(ServerEmailHead h) throws CannotFindEmailException {
		for (ServerEmail e : this.getUserEmail()) {
			if (e.getHead().isEquals(h)) {
				return e;
			}
		}
		throw new CannotFindEmailException("Email doesn't exist");
	}

	public ServerEmail searchEmail(ServerEmailHead h) throws Exception {
			for (ServerEmail s : this.getUserEmail()) {
			 if (h.isEquals(s.getHead())){
				 return s;
			 }
		}
			throw new CannotFindEmailException ("Email doesn't exist");	
	}

	public void deleteEmailByHeader(ServerEmailHead h) throws Exception {
		this.getUserEmail().remove(this.searchEmail(h));
	}

	public void deleteEmailByReader(ServerEmail h) throws Exception {
		    this.getUserEmail().remove(this.searchEmail(h.getHead()));
			}
		
}
