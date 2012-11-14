package server;
import java.util.*;

public class EmailHead  {
    private String subject;
    private Date date;
    private String sender;
    private String reciver;
    
    
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReciver() {
		return reciver;
	}
	public void setReciver(String reciver) {
		this.reciver = reciver;
	}
	
	
	public EmailHead(String subject, Date date, String sender, String reciver) {
		super();
		this.subject = subject;
		this.date = date;
		this.sender = sender;
		this.reciver = reciver;
	}
    
    
    
    
    
	
}
