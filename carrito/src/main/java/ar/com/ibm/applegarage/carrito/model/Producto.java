package ar.com.ibm.applegarage.carrito.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Producto {
	
	private String codigo;
	private String nombre;
//	private List<String> categorias = new ArrayList<>();
	private float precio;
	private List<Propiedad> propiedades = new ArrayList<>();
//	private Map<String,List<String>> templates = new HashMap<>();
	
	public Producto(){
		
	}
	
	
	
	public Producto(String codigo, String nombre, float precio, List<Propiedad> propiedades) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.propiedades = propiedades;
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


	public float getPrecio() {
		return precio;
	}
	
	
	public void setPrecio(float precio) {
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
