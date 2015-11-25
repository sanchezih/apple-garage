package com.ibm.ar.carrito.classes.carrito;

import java.util.HashMap;
import java.util.Map;


public class Carrito {
	private Map <String,Long> productos= new HashMap();

	public Map <String,Long> getProductos() {
		return productos;
	}

	public void setProductos(Map <String,Long> productos) {
		this.productos = productos;
	}


}
