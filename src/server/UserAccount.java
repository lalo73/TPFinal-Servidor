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
         
         
         public void clearList(){
        	 this.getUserEmail().removeAll(this.getUserEmail());
         }
         
         public Email sendEmail(EmailHead h) throws Exception{
        	 for (Email e : this.getUserEmail()){
        		 if (e.getHead() == h){
        			 return e;
        		 }
        	 }
			throw new Exception("Email doesn't exist");
         }
}
