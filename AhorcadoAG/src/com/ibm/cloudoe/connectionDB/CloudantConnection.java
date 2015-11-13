package com.ibm.cloudoe.connectionDB;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.ektorp.CouchDbConnector;
import org.ektorp.CouchDbInstance;
import org.ektorp.http.HttpClient;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbConnector;
import org.ektorp.impl.StdCouchDbInstance;
import org.json.JSONArray;
import org.json.JSONObject;

import com.ibm.cloudoe.model.Category;
import com.ibm.cloudoe.model.Word;
import com.ibm.cloudoe.repositories.CategoryRepository;
import com.ibm.cloudoe.repositories.WordRepository;

public class CloudantConnection {
	
	HttpClient httpClient;
	
	public CloudantConnection(){
		
		try{
			JSONObject obj = new JSONObject(System.getenv("VCAP_SERVICES"));
			String[] names = JSONObject.getNames(obj);

			if (names != null) {
				for (String name : names) {
					if (name.equals("cloudantNoSQLDB")) {
						JSONArray val = obj.getJSONArray(name);
						JSONObject serviceAttr = val.getJSONObject(0);
						JSONObject credentials = serviceAttr.getJSONObject("credentials");
						httpClient = new StdHttpClient.Builder()
		    			.url(credentials.getString("url"))
		    			.build();
						break;
					}
				}
		   }
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public List<Category> getCategories(){
		   CouchDbInstance dbInstance = new StdCouchDbInstance(httpClient);
		   CouchDbConnector db = new StdCouchDbConnector("categoria", dbInstance);
		   CategoryRepository catRepo = new CategoryRepository(db);
		   return catRepo.getAll();
	}
	
	public List<Word> getWords(){
		   CouchDbInstance dbInstance = new StdCouchDbInstance(httpClient);
		   CouchDbConnector db = new StdCouchDbConnector("palabra", dbInstance);
		   WordRepository wordRepo = new WordRepository(db);
		   return wordRepo.getAll();
	}
	
	// METODO HECHO POR NOSOTROS
	public List<Word> getWordsByCategory(String catId){
		List<Word> words = this.getWords();
		List<Word> wordsByCategory = new ArrayList<Word>();
		
		for(int index=0; index<words.size(); index++){
			if(words.get(index).getCategory_id().equals(catId)){
				wordsByCategory.add(words.get(index));
			}
		}
		
		return wordsByCategory;
	}
	
	public Word getRandomWordByCategory(String catId){
		List<Word> words = this.getWordsByCategory(catId);
		Word word = null;
		
		Random generator = new Random();
		if(words.size()>0){
			int random = generator.nextInt(words.size());
			word = words.get(random);
		}
		return word;
	}
	
}
