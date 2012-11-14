package server;
import java.util.*;

public class UserAccount  {
         private User user;
         private ArrayList<Email>userEmail;
         
         
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		public ArrayList<Email> getUserEmail() {
			return userEmail;
		}
		public void setUserEmail(ArrayList<Email> userEmail) {
			this.userEmail = userEmail;
		}
		
		
		public UserAccount(User user ) {
			super();
			this.user = user;
			this.userEmail = new ArrayList<Email>();
		}
         
         
         
}
