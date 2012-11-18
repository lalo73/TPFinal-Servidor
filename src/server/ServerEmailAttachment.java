package server;

public class ServerEmailAttachment {
	String fileName;
	String file;
	
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	
	
	public ServerEmailAttachment(String fileName, String file) {
		super();
		this.fileName = fileName;
		this.file = file;
	}
	
	
	

}
