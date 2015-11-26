package ar.com.ibm.applegarage.carrito.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Carrito {
	private Map <String,Long> productos= new HashMap();
	
	public Map <String,Long> getProductos() {
		return productos;
	}
//
	public void setProductos(Map <String,Long> productos) {
		this.productos = productos;
	}
	
	public void agregarProductoIgual(String id, Long cant)
	{
		Long aux = productos.get(id);
		productos.replace(id, aux+cant);
	}
	public void agregar(String id, Long cant)
	{
		productos.put(id, cant);
	}
	public void cambiar(String id, Long cant)
	{
		productos.replace(id, cant);
	}
	public void eliminar(String id)
	{
		productos.remove(id);
	}
	

}
