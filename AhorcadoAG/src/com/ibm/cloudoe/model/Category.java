package com.ibm.cloudoe.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties({"id", "revision"})
public class Category {
	
	@JsonProperty("_id") 
	private String id; 
	
	@JsonProperty("_rev") 
	private String revision;
	
	private String name;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRevision() {
		return revision;
	}
	public void setRevision(String revision) {
		this.revision = revision;
	}
	public String getName() {
		return name;
	}
	public void setName(String nombreCadena) {
		this.name = nombreCadena;
	}
	
	

}
