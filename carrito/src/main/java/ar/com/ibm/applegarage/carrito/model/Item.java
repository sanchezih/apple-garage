package ar.com.ibm.applegarage.carrito.model;

public class Item {

	private Producto producto;
	private long cantidad;
	
	public Item(){
		
	}
	
	public Item(Producto producto, long cantidad) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public long getCantidad() {
		return cantidad;
	}

	public void setCantidad(long l) {
		this.cantidad = l;
	}
	
}