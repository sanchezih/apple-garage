package com.ibm.ar.carrito.classes.product;

public class Producto {
	private int precio;
	private String codigo;
	private String _id;
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String get_id() {
		return _id;
	}
	public void set_id() {
		this._id = this.codigo;
	}
}
