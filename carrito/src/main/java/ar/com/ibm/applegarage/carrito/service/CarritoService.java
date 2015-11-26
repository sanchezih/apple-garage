package ar.com.ibm.applegarage.carrito.service;

import ar.com.ibm.applegarage.carrito.model.Carrito;
import ar.com.ibm.applegarage.carrito.model.Producto;

/*	similar a StockService, pero agrega elementos ProductoYCantidad a una coleccion y
 * otras propiedades como puede ser estado:{abierto/cerrado}, el usuario al que 
 * esta asociado, en caso de querer tener todos los carritos en otra db, etc.
 *  
 */

public class CarritoService {
	
	private Carrito carrito = new Carrito();
	
	public void agregarItem(String id,Long cant){
		
		if(carrito.getProductos().containsKey(id))
		{
			carrito.agregarProductoIgual(id, cant);
		}else 
			carrito.agregar(id, cant);
	}
	
	public void cambiarCant(String id, Long cant){
			carrito.cambiar(id, cant);
	}
	
	public void  eliminarItem(String id){
			carrito.eliminar(id);
	}
}
