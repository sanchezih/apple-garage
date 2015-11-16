package org.joshua.javabrains.messenger.database;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joshua.javabrains.messenger.model.Message;
import org.joshua.javabrains.messenger.model.Profile;

import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;

public class DatabaseClass {
	
	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<String, Profile> profiles = new HashMap<>();
	
	public static Map<Long, Message > getMessages(){
		return messages;
	}
	
	public static Map<String, Profile> getProfiles(){
		return profiles;
	}
	
	/*
	public void conexionCloudant()
	{
		
		//String password = System.getProperty("");
		CloudantClient client = new CloudantClient("jgdlve","jgdlve","1234");
		
		System.out.println("Connected to Cloudant");
		System.out.println("Server Version: " + client.serverVersion());

		List<String> databases = client.getAllDbs();
		System.out.println("All my databases : ");
		for ( String db : databases ) {
		    System.out.println(db);
		}
	System.out.println(client.replication());
		
	}*/
	
	

}
