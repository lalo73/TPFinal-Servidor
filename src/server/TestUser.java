package server;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestUser {
	User u;

	@Before
	public void setUp() throws Exception {
		u = new User("Fede", "isComplicated","Jfflores90@gmail.com");
		
	}
	@Test
	public void testgetUser() {
		assertEquals(u.getName(),"Fede");
		
	}
    @Test
    public void testgetUserName(){
    	assertEquals(u.getUserName(),"Jfflores90@gmail.com");
    }
    @Test
    public void testgetPassword(){
    	assertEquals(u.getPassword(),"isComplicated");
    }
}