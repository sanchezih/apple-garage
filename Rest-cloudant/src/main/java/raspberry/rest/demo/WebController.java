package raspberry.rest.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cloudant.client.api.Database;
import com.cloudant.client.api.model.FindByIndexOptions;
import com.cloudant.client.api.model.IndexField;
import com.cloudant.client.api.model.IndexField.SortOrder;
import com.cloudant.client.api.model.Response;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

  
  
/** 
 * @author JITHINRAJ.P
 * @author email : jithinrajktd@gmail.com
 */  
/*

  findByIndex("\selector\": {"\_id"\: { "\$gt\": 0}},
  Books.class,new FindByIndexOptions().
  sort(new IndexField("title",sortOrder.asc).
  fields("title").fields("author"));


 */

@Path("/webservice")  
public class WebController {  
   
     @GET  
     @Path("/echo/{message}")  
     @Produces("text/plain")  
     public String showMsg(@PathParam("message") String message){  
         return message;      
     }  
       
     
     @GET 
     @Path("/insert/{name}/{by}/{likes}/{year}/{description}")  
     @Produces("text/plain")  
     public String insert(@PathParam("name") String name  , @PathParam("description") String description , @PathParam("likes") Long likes , @PathParam("year") String year , @PathParam("by") String by){
    	 //MongoDBSingleton dbSingleton = MongoDBSingleton.getInstance();
    	 CloudantDBSingleton dbSingleton = CloudantDBSingleton.getInstance();
    	 //DB db = dbSingleton.getTestdb();
    	 Database db = dbSingleton.testDatabase();
    	// DBCollection coll = db.getCollection("Books");	
    	// BasicDBObject doc = new BasicDBObject("title", name).
    		//	 append("description", description).
    			// append("likes", likes).
    		//	 append("year", year).
    		//	 append("by", by);
    	// coll.insert(doc);
    	 Books book = new Books();
    	 book.setTitle(name);
    	 book.setDescription(description);
    	 book.setLikes(likes);
    	 book.setYear(year);
    	 book.setBy(by);
    	 Response r = db.post(book);
    	return r.getId() + " ; " + db.getDBUri();

     }  
     
     @GET 
     @Path("/getRecords")  
     @Produces(MediaType.APPLICATION_JSON)  
     public List<Books> getRecords(){
    	 /*MongoDBSingleton dbSingleton = MongoDBSingleton.getInstance();
    	 DB db = dbSingleton.getTestdb();*/
    	 CloudantDBSingleton dbSingleton = CloudantDBSingleton.getInstance();
    	 Database db = dbSingleton.testDatabase();
    	 //DBCollection coll = db.getCollection("Books");	
    	 //DBCursor cursor = coll.find().sort(new BasicDBObject("by", 1));
    	 List<Books> list = db.  findByIndex("\"selector\": { \"_id\": { \"$gt\": 0} }",Books.class);

    			 //.includeDocs(true)
    			// .query(Books.class); 
    	 //while (cursor.hasNext()) { 
            /* DBObject o = cursor.next();
             Books bools = new Books();
             bools.setTitle((String) o.get("title"));
             bools.setDescription((String) o.get("description"));
             bools.setYear((String) o.get("year"));
             bools.setBy((String) o.get("by"));
             bools.setLikes((Long) o.get("likes"));
             list.add(bools);
          }*/
    	 return list;
     } 
     
     @GET 
     @Path("/getRecord/{title}")  
     @Produces(MediaType.APPLICATION_JSON)  
     public List<Books> getRecordFromName(@PathParam("title") String message){
    	 /*MongoDBSingleton dbSingleton = MongoDBSingleton.getInstance();
    	 DB db = dbSingleton.getTestdb();
    	 DBCollection coll = db.getCollection("Books");	
    	 DBCursor cursor = coll.find(new BasicDBObject("title", message));
    	 List<Books> list = new ArrayList<Books>();
    	 while (cursor.hasNext()) { 
             DBObject o = cursor.next();
             Books bools = new Books();
             bools.setTitle((String) o.get("title"));
             bools.setDescription((String) o.get("description"));
             bools.setYear((String) o.get("year")); 
             bools.setBy((String) o.get("by"));
             list.add(bools);
          }*/
    	 CloudantDBSingleton dbSingleton = CloudantDBSingleton.getInstance();
    	 Database db = dbSingleton.testDatabase();
    	 List<Books> list = db.findByIndex("\"selector\": {\"title\": \""+message+"\" }"
   			  ,Books.class);
    	 return list;
     } 
}  