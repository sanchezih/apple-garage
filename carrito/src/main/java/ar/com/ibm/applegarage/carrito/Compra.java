package ar.com.ibm.applegarage.carrito;

import java.util.Date;

import ar.com.ibm.applegarage.carrito.model.Carrito;

public class Compra {
	private Date fecha;
	private Carrito carrito;
	private int idcompra;
	public Carrito getCarrito() {
		return carrito;
	}
	public void setCarrito(Carrito carrito) {
		this.carrito = carrito;
	}
	public int getIdcompra() {
		return idcompra;
	}
	public void setIdcompra(int idcompra) {
		this.idcompra = idcompra;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}