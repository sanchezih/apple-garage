package raspberry.rest.demo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Books")  
public class Books {

	private String title;  
	private String _id;
	private String description;  
	private String year; 
	private String by; 
	private String _rev;
	public String get_rev() {
		return _rev;
	}
	public void set_rev(String _rev) {
		this._rev = _rev;
	}
	private long likes;
	
	public void setTitle(String String){
		this.title = String;
		set_id();
	}
	public void setDescription(String String){
		this.description = String;
	}
	
	public void setLikes(long String){
		this.likes = String;
	}
	public void setYear(String String){
		this.year = String;
	}
	public void setBy(String String){
		this.by = String;
	}
	public void set_id()
	{
		this._id = title;
	}
	
	@XmlElement  
	public String getTitle(){
		return this.title ;
	}
	@XmlElement  
	public String getDescription(){
		return this.description;
	}
	@XmlElement  
	public long getLikes(){
		return this.likes;
	}
	@XmlElement  
	public String getYear(){
		return this.year ;
	}
	@XmlElement  
	public String getBy(){
		return this.by;
	}
}
