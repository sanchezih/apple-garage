package ar.com.ibm.applegarage.carrito.model;

public class Propiedad {

	private String key;
	private String value;
//	private boolean isIdGenFactor;
	
	public Propiedad (){
		
	}
	
	public Propiedad(String key, String value) {
		super();
		this.key = key;
		this.value = value;
//		this.isIdGenFactor = false;
	}
	
	
//	public Propiedad(String key, String value, boolean fact) {
//		super();
//		this.key = key;
//		this.value = value;
//		this.isIdGenFactor = fact;
//	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

//	public boolean isIdGenFactor() {
//		return isIdGenFactor;
//	}
//
//	public void setIdGenFactor(boolean isIdGenFactor) {
//		this.isIdGenFactor = isIdGenFactor;
//	}
	
	
	
}