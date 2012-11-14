package server;
import java.util.*;

public class UserAccount  {
         private User userAccount;
         private ArrayList<Email>userEmail;
         
         
		public User getUserAccount() {
			return userAccount;
		}
		public void setUserAccount(User user) {
			this.userAccount = user;
		}
		public ArrayList<Email> getUserEmail() {
			return userEmail;
		}
		public void setUserEmail(ArrayList<Email> userEmail) {
			this.userEmail = userEmail;
		}
		
		
		public UserAccount(User user ) {
			super();
			this.userAccount = user;
			// CREATION OF AN EMPTY EMAIL LIST..
			this.userEmail = new ArrayList<Email>();
		}
         
         
         
}
