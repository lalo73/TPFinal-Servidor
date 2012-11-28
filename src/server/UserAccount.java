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
			if (e.getHead() == h) {
				return e;
			}
		}
		throw new CannotFindEmailException("Email doesn't exist");
	}
}
