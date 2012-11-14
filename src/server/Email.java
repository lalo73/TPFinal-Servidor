package server;

import java.util.*;

public class Email  {
	
     private EmailHead head;
     private boolean isReaded;
     private ArrayList<Attachment> attachment;
     private String body;
	
     
     
    public boolean isReaded() {
		return isReaded;
	}
	public void setReaded(boolean isReaded) {
		this.isReaded = isReaded;
	}
	public ArrayList<Attachment> getAttachment() {
		return attachment;
	}
	public void setAttachment(ArrayList<Attachment> attachment) {
		this.attachment = attachment;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public void setHead(EmailHead head) {
		this.head = head;
	}
	public EmailHead getHead() {
		return head;
	}

	
     
	
}
