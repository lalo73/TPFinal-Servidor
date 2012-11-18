package server;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TestServerEmail {
	ServerEmailAttachment a;
	ServerEmailHead eh;
	ServerEmail e;
	
	public void setUp(){
		a = mock(ServerEmailAttachment.class);
		when(a.getFile()).thenReturn("aFile");
		when(a.getFileName()).thenReturn("aFileName");
		eh = mock(ServerEmailHead.class);
		when(eh.getDate()).thenReturn(Calendar.getInstance());
		when(eh.getReciver()).thenReturn("Jfflores90@gmail.com");
		when(eh.getSender()).thenReturn("lalo73@gmail.com");
		when(eh.getSubject()).thenReturn("aSubject");
		ArrayList<ServerEmailAttachment>at = new ArrayList<ServerEmailAttachment>();
		at.add(a);
		e = new ServerEmail(eh,at,"aBody");
		
	}

	@Test
	public void testisReaded() {
		assertTrue(e.isReaded() == false);
	}

	@Test
	public void testgetBody(){
		assertEquals(e.getBody(),"aBody");
	}
	@Test
	public void testgetHead(){
		assertEquals(e.getHead().getReciver(),"Jfflores90@gmail.com");
		assertEquals(e.getHead().getSender(),"lalo73@gmail.com");
		assertEquals(e.getAttachment().get(0),a);
		assertEquals(e.getHead().getDate(),eh.getDate());
	}
}
