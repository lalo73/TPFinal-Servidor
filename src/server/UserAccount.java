package server;
/**
 * @Author: Flores Jorge
 */
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
		/*
		 * this method delete all emails from an User
		 */
		this.getUserEmail().removeAll(this.getUserEmail());
	}

	public ServerEmail sendEmailComplete(ServerEmailHead h) throws CannotFindEmailException {
		/*
		 * this method must return an Email complete 
		 * search by the EmailHead
		 * if not exist throw an Exception
		 */
		for (ServerEmail e : this.getUserEmail()) {
			if (e.getHead().equals(h)) {
				return e;
			}
		}
		throw new CannotFindEmailException("Email doesn't exist");
	}

	private  ServerEmail searchEmail(ServerEmailHead h) throws Exception {
			for (ServerEmail s : this.getUserEmail()) {
			 if (s.getHead().equals(h)){
				 return s;
			 }
		}
			throw new CannotFindEmailException ("Email doesn't exist");	
	}

	public void deleteEmailByHeader(ServerEmailHead h) throws Exception {
		/*
		 * this method must delete an email by the EmailHead
		 */
		this.getUserEmail().remove(this.searchEmail(h));
	}

	public void deleteEmailByReader(ServerEmail h) throws Exception {
		/*
		 * this method delete an Email if this was readed
		 */
		    this.getUserEmail().remove(this.searchEmail(h.getHead()));
			}
		
}
