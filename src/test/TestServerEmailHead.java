package test;

import server.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Calendar;

public class TestServerEmailHead {
	ServerEmailHead eh;
	Calendar d;
	

	@Before
	public void setUp(){
		d = Calendar.getInstance();
		d.set(Calendar.YEAR,2009);
		d.set(Calendar.MONTH, 9);
		d.set(Calendar.DAY_OF_MONTH,30);
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
    

	@Test
    public void testgetDate(){
		assertEquals(eh.getDate(),d);
		assertEquals(eh.getDate().get(Calendar.YEAR),2009);
		assertEquals(eh.getDate().get(Calendar.DAY_OF_MONTH),30);
		assertEquals(eh.getDate().get(Calendar.MONTH),9);
		
		}
   
}