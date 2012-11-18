package server;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestServerEmailAttachment {
   ServerEmailAttachment at;
   
   @Before
   public void setUp(){
	   at = new ServerEmailAttachment("photo","aPicture");
	   
   }
   @Test
   public void testgetFileName(){
	   assertEquals(at.getFileName(),"photo");
	   assertFalse (at.getFileName() == "aPicture");
   }
   @Test
   public void testgetFile(){
	   assertEquals(at.getFile(),"aPicture");
	   assertFalse(at.getFile() == "photo");
   }

}
