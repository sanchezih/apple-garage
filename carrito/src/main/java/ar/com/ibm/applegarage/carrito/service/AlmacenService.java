package ar.com.ibm.applegarage.carrito.service;

import java.util.ArrayList;
import java.util.List;

import com.cloudant.client.api.Database;

import ar.com.ibm.applegarage.carrito.database.CloudantDBSingleton;
import ar.com.ibm.applegarage.carrito.model.Item;
import ar.com.ibm.applegarage.carrito.model.Producto;
import ar.com.ibm.applegarage.carrito.model.Propiedad;

/*
 * ABM para base de stock
 */

public class AlmacenService {
	
	private CloudantDBSingleton cdbsing = CloudantDBSingleton.getInstance();
	
	
	
	public void agregarItem(Item item){
//		EL ID DEBE SER UNICO
//		producto.setCodigo("algun metodo de generacion de codigo");
		Database db = cdbsing.getDatabase();
		try{
			db.post(item);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void test(Item item){
		
		Database db = cdbsing.getDatabase();
		db.post(item);
	}

}