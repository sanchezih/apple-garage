package ar.com.ibm.applegarage.carrito.database;

import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;

public class CloudantDBSingleton {
	private static CloudantClient cloudantClient;
	private static CloudantDBSingleton cDbSingleton;
	private static Database db;
	private static final String dbName = "carrito_stock";
	private static final String dbUser = "dieveriedvannezindstaget";
	private static final String dbPassword = "a00cc3e1cb7f21972c7d1b102070a3a02bd261ab";
	private static final String dbHost = "ibmapplegarage";
	
	private CloudantDBSingleton(){};
	
	public static CloudantDBSingleton getInstance(){
		
		if (cDbSingleton == null){
			cDbSingleton = new CloudantDBSingleton();
		}
		return cDbSingleton;
		
	}
	
	public Database getDatabase(){
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