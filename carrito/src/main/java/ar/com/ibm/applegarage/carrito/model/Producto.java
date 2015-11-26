package ar.com.ibm.applegarage.carrito.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Producto {
	
	private String codigo;
//	private String nombre;
//	private List<String> categorias = new ArrayList<>();
	private int precio;
	private List<Propiedad> propiedades = new ArrayList<>();
//	private Map<String,List<String>> templates = new HashMap<>();
	
	public Producto(){
		
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getPrecio() {
		return precio;
	}
	
	
	public void setPrecio(int precio) {
		this.precio = precio;
	}

	
	public List<Propiedad> getPropiedades() {
		return propiedades;
	}


	public void setPropiedades(List<Propiedad> propiedades) {
		this.propiedades = propiedades;
	}

	
//	public Map<String,List<String>> getTemplates() {
//		return templates;
//	}
//	
//
//	public void setTemplates(Map<String,List<String>> templates) {
//		this.templates = templates;
//	}


	
	
}
