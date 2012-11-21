package test;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.Before;
import org.junit.Test;

import server.Server;
import server.ServerEmail;
import server.ServerEmailAttachment;
import server.ServerEmailHead;
import server.User;
import server.UserAccount;
import static org.mockito.Mockito.*;

public class TestServer {
	ServerEmailAttachment a;
	ServerEmailHead eh;
	ServerEmail e;
	ServerEmail e2;
	User u;
	UserAccount ua;
	Server s;

	@Before
	public void setUp() throws Exception {

		ArrayList<ServerEmailAttachment> at = new ArrayList<ServerEmailAttachment>();
		ArrayList<ServerEmail> em = new ArrayList<ServerEmail>();
		//ArrayList<UserAccount>uas = new ArrayList<UserAccount>();
		Calendar d = Calendar.getInstance();
		a = mock(ServerEmailAttachment.class);
		when(a.getFile()).thenReturn("hi");
		when(a.getFileName()).thenReturn("aName");
		at.add(a);
		eh = mock(ServerEmailHead.class);
		when(eh.getDate()).thenReturn(d);
		when(eh.getReciver()).thenReturn("Jfflores90@gmail.com");
		when(eh.getSender()).thenReturn("lalo93@gmail.com");
		when(eh.getSubject()).thenReturn("I've a question");
		e = mock(ServerEmail.class);
		em.add(e);
		when(e.getBody()).thenReturn("Am I ugly?");
		when(e.getHead()).thenReturn(eh);
		when(e.getAttachment()).thenReturn(at);
		e2 = mock(ServerEmail.class);
		when(e2.getAttachment()).thenReturn(at);
		when(e2.getHead()).thenReturn(eh);
		when(e2.getBody()).thenReturn("Hello");
		u = mock(User.class);
		when(u.getName()).thenReturn("Fede");
		when(u.getPassword()).thenReturn("is secret");
		when(u.getUserName()).thenReturn("Jfflores90@gmail.com");
		ua = mock(UserAccount.class);
		when(ua.getUserAccount()).thenReturn(u);
		when(ua.getUserEmail()).thenReturn(em);
		ua.getUserEmail().add(e);
		//uas.add(ua);
		s = new Server();
		s.getUsers().add(ua);
	}

	@Test
	public void testsendEmailWithPOP3() throws Exception {
		assertEquals(s.sendEmailWithPOP3("Jfflores90@gmail.com",false).get(0),ua.getUserEmail().get(0));
		try{
			s.sendEmailWithPOP3("pepito@gmail.com", false);
		}catch(CannotFindUserException e){
			
		}
	}
	
	@Test
	public void testsendEmailWithIMAP()throws Exception {
		//assertEquals(s.sendEmailWithIMAP("Jfflores90@gmail.com").get(0),eh);
		assertEquals(ua.getUserEmail().size(),null);
	}
	
	@Test
	public void testsendEmail() throws Exception{
		s.sendEmail(eh,"Jfflores90@gmail.com");
		verify(s).sendEmail(eh,"Jfflores90@gmail.com"); 
	}
	
	@Test
	public void testreciveAndSend() throws Exception{
		s.recivedAndSend(e2);
		assertTrue(ua.getUserEmail().size() == 2);
	}

}