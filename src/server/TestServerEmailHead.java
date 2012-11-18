package server;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import java.util.Calendar;

public class TestServerEmailHead {
	ServerEmailHead eh;
	Calendar d;
	
	@SuppressWarnings("static-access")
	@Before
	public void setUp(){
		d = mock (Calendar.class);
		when(d.DAY_OF_MONTH).thenReturn(30);
		when(d.MONTH).thenReturn(9);
		when(d.YEAR).thenReturn(2012);
		eh = new ServerEmailHead("Jfflores90@gmail.com","subject",d,"lalo73@gmail.com");
	}

	@Test
	public void testgetReciver() {
		assertEquals(eh.getReciver(),"Jfflores90@gmail.com");
		}
    @Test
    public void testgetSender(){
    	assertEquals(eh.getSender(),"lalo73@gmail.com");
    }
    @Test
    public void testgetSubject(){
    	assertEquals(eh.getSubject(),"subject");
    }
    @SuppressWarnings("static-access")
	@Test
    public void testgetDate(){
		assertEquals(eh.getDate().DAY_OF_MONTH,30);
		assertEquals(eh.getDate().MONTH,9);
		assertEquals(eh.getDate().YEAR,2012);
    }
}
