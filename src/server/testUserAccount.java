package server;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.Before;
import org.junit.Test;
import server.*;
import static org.mockito.Mockito.*;
import java.util.Date;

public class testUserAccount  {
	Attachment a;
	EmailHead eh;
	Email e;
	User u;
	UserAccount ua;
	

	@Before
	public void setUp() throws Exception{
		
		  ArrayList<Attachment>at = new ArrayList<Attachment>();
		  ArrayList<Email> em = new ArrayList<Email>();
		  Date d;
		  d = new Date();
	      a = mock (Attachment.class);
	      when(a.getFile()).thenReturn("hi");
	      when(a.getFileName()).thenReturn("aName");
	      at.add(a);
	      eh = mock (EmailHead.class);
	      when(eh.getDate()).thenReturn(d);
	      when(eh.getReciver()).thenReturn("Jfflores90@gmail.com");
	      when(eh.getSender()).thenReturn("lalo93@gmail.com");
	      when(eh.getSubject()).thenReturn("I've a question");
	      e = mock (Email.class);
	      em.add(e);
	      when(e.getBody()).thenReturn("Am I ugly?");
	      when(e.getHead()).thenReturn(eh);
	      when(e.getAttachment()).thenReturn(at);
	      u = mock (User.class);
	      when(u.getName()).thenReturn("Fede");
	      when(u.getPassword()).thenReturn("is secret");
	      when(u.getUserName()).thenReturn("Jfflores90@gmail.com");
	      ua = new UserAccount (u);
	      ua.getUserEmail().add(e);
	}

	@Test
	public void testsendEmail() throws Exception  {
		assertTrue(ua.sendEmail(eh) == e);
	}
  
}
