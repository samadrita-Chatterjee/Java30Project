package in.ineron.model;

public class User {
	private int sino;
	private String title;
	private String description;
	private  String content;
	
	public User(int sino, String title, String description, String content) {
		super();
		this.sino = sino;
		this.title = title;
		this.description = description;
		this.content = content;
	}
	
	public User(String title, String description, String content) {
		super();
		this.title = title;
		this.description = description;
		this.content = content;
	}

	public int getSino() {
		return sino;
	}
	public void setSino(int sino) {
		this.sino = sino;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
	
	
	