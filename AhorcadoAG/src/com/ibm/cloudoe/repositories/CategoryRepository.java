package com.ibm.cloudoe.repositories;

import org.ektorp.CouchDbConnector;
import org.ektorp.support.CouchDbRepositorySupport;

import com.ibm.cloudoe.model.Category;


public class CategoryRepository extends CouchDbRepositorySupport<Category>{
	
	public CategoryRepository(CouchDbConnector db) {
	     super(Category.class, db);
	     
	    
	}
	
	

}
