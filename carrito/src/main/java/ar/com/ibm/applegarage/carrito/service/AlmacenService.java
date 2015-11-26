package ar.com.ibm.applegarage.carrito.service;

import ar.com.ibm.applegarage.carrito.database.CloudantDBSingleton;
import ar.com.ibm.applegarage.carrito.model.Producto;
import ar.com.ibm.applegarage.carrito.model.ProductoYCantidad;

/*
 * ABM para base de stock
 */

public class AlmacenService {
	
	private CloudantDBSingleton cdbsing = CloudantDBSingleton.getInstance();
	
	public AlmacenService(){
		
	}
	
	public void agregarItem(Producto producto, int cantidad){
//		EL ID DEBE SER UNICO
//		producto.setCodigo("algun metodo de generacion de codigo");
		ProductoYCantidad item = new ProductoYCantidad(producto,cantidad);
		
		
	}
	
	public void quitarItem(String key){
		
	}
	
	public void modifCant(String key, long cantidad){
		
	}
	
	public void modifProducto(Producto producto){

		
		
	}
	

}