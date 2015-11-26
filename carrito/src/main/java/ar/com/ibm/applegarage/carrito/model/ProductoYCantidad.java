package ar.com.ibm.applegarage.carrito.model;

public class ProductoYCantidad {

	private Producto producto;
	private int cantidad;
	
	public ProductoYCantidad(){
		
	}
	
	public ProductoYCantidad(Producto producto, int cantidad) {
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

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
}