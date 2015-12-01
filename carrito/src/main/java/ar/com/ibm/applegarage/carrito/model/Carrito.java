package ar.com.ibm.applegarage.carrito.model;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Carrito {
	private Map <String,Long> productos= new HashMap<>();
//	private List<Item> productos = new ArrayList<>();
	
	public Map <String,Long> getProductos() {
		return productos;
	}
//
	public void setProductos(Map <String,Long> productos) {
		this.productos = productos;
	}
	
	public void agregarProductoIgual(String id, long cant)
	{
		long aux = productos.get(id);
		productos.put(id, aux+cant);
	}
	public void agregar(String id, Long cant)
	{
		productos.put(id, cant);
	}
	public void cambiar(String id, Long cant)
	{
		productos.put(id, cant);
	}
	public void eliminar(String id)
	{
		productos.remove(id);
	}
	

}
