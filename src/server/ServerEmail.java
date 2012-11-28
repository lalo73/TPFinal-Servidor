package server;

import java.util.*;

public class ServerEmail  {
	
     private ServerEmailHead head;
     private boolean isReaded;
     private ArrayList<ServerEmailAttachment> attachment;
     private String body;
	
     
     
    public boolean isReaded() {
		return isReaded;
	}
	public void setReaded(boolean isReaded) {
		this.isReaded = isReaded;
	}
	public ArrayList<ServerEmailAttachment> getAttachment() {
		return attachment;
	}
	public void setAttachment(ArrayList<ServerEmailAttachment> attachment) {
		this.attachment = attachment;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public void setHead(ServerEmailHead head) {
		this.head = head;
	}
	public ServerEmailHead getHead() {
		return head;
		
		
	}
	public ServerEmail(ServerEmailHead head,ArrayList<ServerEmailAttachment> attachment, String body) {
		super();
		this.head = head;
		this.isReaded = false;
		this.attachment = attachment;
		this.body = body;
	}

}