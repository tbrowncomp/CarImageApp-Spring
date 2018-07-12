package com.carscroll.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Images {
	
	@Id
	public String _id;
	
	public String user;
	public String caption;
	public String location;
	public List<String> tags;
	
}
