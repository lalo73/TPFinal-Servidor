package test;

import server.*;
import exception.CannotFindEmailException;
import static org.junit.Assert.*;
import java.util.*;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TestUserAccount {
	
	ServerEmailAttachment a;
	ServerEmailHead eh;
	ServerEmailHead eh2;
	ServerEmail e;
	ServerEmail e2;
	ServerEmail e3;
	ServerUser  u;
	UserAccount ua;
	Calendar d = Calendar.getInstance();

	@Before
	public void setUp() throws Exception {

		ArrayList<ServerEmailAttachment> at = new ArrayList<ServerEmailAttachment>();
		ArrayList<ServerEmail> em = new ArrayList<ServerEmail>();
		//ArrayList<UserAccount>uas = new ArrayList<UserAccount>();
		Calendar d =  Calendar.getInstance();
		a = mock(ServerEmailAttachment.class);
		when(a.getFile()).thenReturn("hi");
		when(a.getFileName()).thenReturn("aName");
		at.add(a);
		eh = mock(ServerEmailHead.class);
		when(eh.getDate()).thenReturn(d);
		when(eh.getReciver()).thenReturn("Jfflores90@gmail.com");
		when(eh.getSender()).thenReturn("lalo93@gmail.com");
		when(eh.getSubject()).thenReturn("I've a question");
		when(eh.getDate()).thenReturn(d);
		eh2 = mock(ServerEmailHead.class);
		when(eh2.getDate()).thenReturn(d);
		when(eh2.getReciver()).thenReturn("Jfflores90@gmail.com");
		when(eh2.getSender()).thenReturn("lalo93@gmail.com");
		when(eh2.getSubject()).thenReturn("Hello!!");
		e = mock(ServerEmail.class);
		em.add(e);
		when(e.getBody()).thenReturn("Am I ugly?");
		when(e.getHead()).thenReturn(eh);
		when(e.getAttachment()).thenReturn(at);
		e2 = mock(ServerEmail.class);
		when(e2.getAttachment()).thenReturn(at);
		when(e2.getHead()).thenReturn(eh2);
		when(e2.getBody()).thenReturn("Hello");
		when(e2.isReaded()).thenReturn(true);
		e3 = mock(ServerEmail.class);
		when(e3.isReaded()).thenReturn(false);
		when(e3.getHead()).thenReturn(eh2);
		u = mock(ServerUser .class);
		when(u.getName()).thenReturn("Fede");
		when(u.getPassword()).thenReturn("is secret");
		when(u.getUserName()).thenReturn("Jfflores90@gmail.com");
		ua = new UserAccount(u);
		ua.getUserEmail().add(e);
	}

	@Test
	public void testgetUserAccount() {
	  assertEquals(ua.getUserAccount(),u);
	}
	
	@Test
	public void testgetUserEmail(){
		assertEquals(ua.getUserEmail().get(0).getBody(),e.getBody());
	}
	
	@Test
	public void testsendEmailComplete() throws Exception{
		assertEquals(ua.getUserEmail().get(0),e);
		assertEquals(ua.sendEmailComplete(eh),e);
		try{
			ua.sendEmailComplete(eh2);
			fail("Exception not captured");
	       }catch (CannotFindEmailException e){
			
		      }
	}
	
	@Test
	public void testDeleteByReader() throws Exception{
		ua.getUserEmail().add(e2);
		assertEquals(ua.getUserEmail().size(),2);
		ua.deleteEmailByReader(e2);
		assertEquals(ua.getUserEmail().size(),1);
		try{
			ua.deleteEmailByReader(e3);
			fail("Exception not captured");
		}catch (CannotFindEmailException e){
			
	     }
   }
	@Test
	public void testDeleteByHeader()throws Exception{
		assertEquals(ua.getUserEmail().size(),1);
		ua.deleteEmailByHeader(eh);
		assertEquals(ua.getUserEmail().size(),0);
		try{
			ua.deleteEmailByHeader(eh2);
			fail("Exception not captured");
		}catch (CannotFindEmailException e){
			
		}
	}
}
