package com.ibm.cloudoe.repositories;

import org.ektorp.CouchDbConnector;
import org.ektorp.support.CouchDbRepositorySupport;

import com.ibm.cloudoe.model.Word;

public class WordRepository extends CouchDbRepositorySupport<Word>{
	
	public WordRepository(CouchDbConnector db) {
	     super(Word.class, db);
	}

}
