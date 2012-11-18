package server;

import java.util.*;

public class UserAccount {
	private User userAccount;
	private ArrayList<ServerEmail> userEmail;

	public User getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(User user) {
		this.userAccount = user;
	}

	public ArrayList<ServerEmail> getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(ArrayList<ServerEmail> userEmail) {
		this.userEmail = userEmail;
	}

	public UserAccount(User user) {
		super();
		this.userAccount = user;
		// CREATION OF AN EMPTY EMAIL LIST..
		this.userEmail = new ArrayList<ServerEmail>();
	}

	public void clearList() {
		this.getUserEmail().removeAll(this.getUserEmail());
	}

	public ServerEmail sendEmailComplete(ServerEmailHead h) throws Exception {
		for (ServerEmail e : this.getUserEmail()) {
			if (e.getHead() == h) {
				return e;
			}
		}
		throw new Exception("Email doesn't exist");
	}
}
