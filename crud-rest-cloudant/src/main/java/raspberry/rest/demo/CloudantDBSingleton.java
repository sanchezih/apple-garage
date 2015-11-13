package raspberry.rest.demo;

import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;

public class CloudantDBSingleton {
	private static CloudantClient cloudantClient;
	private static CloudantDBSingleton cDbSingleton;
	private static Database db;
	private static final String dbName = "books";
	private static final String dbUser = "hassockeendlylittalients";
	private static final String dbPassword = "b0c04eb88c02d23d168eabad8227df7cd660bb87";
	private static final String dbHost = "matiasarapura";
	
	private CloudantDBSingleton(){};
	
	public static CloudantDBSingleton getInstance(){
		
		if (cDbSingleton == null){
			cDbSingleton = new CloudantDBSingleton();
		}
		return cDbSingleton;
		
	}
	
	public Database testDatabase(){
		if(cloudantClient==null){
		try {
			cloudantClient =  new CloudantClient(dbHost,dbUser,dbPassword);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		}
		if(db==null)
		{	
			try {
				db = cloudantClient.database(dbName,true);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		return db;
	}
	
}
	

