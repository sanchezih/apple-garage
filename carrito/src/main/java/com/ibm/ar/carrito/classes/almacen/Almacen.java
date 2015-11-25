package com.ibm.ar.carrito.classes.almacen;

import java.util.List;

import com.ibm.ar.carrito.classes.product.Producto;

public class Almacen {
	private List<Producto> stock;
	
	void agregar(){}
	void quitar(){}
	void verStock(){}
	public List<Producto> getStock() {
		return stock;
	}
	public void setStock(List<Producto> stock) {
		this.stock = stock;
	}
}
