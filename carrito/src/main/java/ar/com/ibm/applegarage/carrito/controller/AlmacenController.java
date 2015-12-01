package ar.com.ibm.applegarage.carrito.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import ar.com.ibm.applegarage.carrito.model.Item;
import ar.com.ibm.applegarage.carrito.model.Producto;
import ar.com.ibm.applegarage.carrito.model.Propiedad;
import ar.com.ibm.applegarage.carrito.service.AlmacenService;

@Path("/stock")
//@Produces(MediaType.APPLICATION_JSON)
//@Consumes(MediaType.APPLICATION_JSON)
public class AlmacenController {

	
	AlmacenService svc = new AlmacenService();
	
	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/items")
	@GET
	public String getStockItems(){
		return "devolver aca los docs";
	}
	
	@GET
	@Path("/test")
	public String test(){
		
		Propiedad prop1 = new Propiedad();
		Propiedad prop2 = new Propiedad();
		prop1.setKey("proyecto");prop1.setValue("mapple");
		prop2.setKey("color");prop2.setValue("indiGo!");
		List<Propiedad> props = new ArrayList<>();
		props.add(prop1);props.add(prop2);
		
		Producto p1 = new Producto();
		p1.setCodigo("asd123");
		p1.setNombre("cubierto_descartable");
		p1.setPrecio((float)32.5);
		p1.setPropiedades(props);
		
		Item item = new Item();
		item.setProducto(p1);
		item.setCantidad(24);
		
		svc.test(item);
		
		return "ok";
	}
	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/items")
	@POST
	public String addStockItem(Producto producto,
								@QueryParam("cant") long cant){
		if (cant<=0){
			cant = 1;
		}
		svc.agregarItem(new Item(producto, cant));
		return "ok";
	}
	
/*	
//	este metodo modifica el producto, y opcionalmente su cantidad
	@Path("/items/{idProducto}")
	@PUT
	public void updateStockItem(@PathParam("idProducto") String id,
								@QueryParam("cant") Long cant,
								Producto producto){
		
//		quizas se quiera modificar el ID del producto, asique especificar el targetid.
//		svc.modifProducto(id, producto);
		if(cant.intValue()>0){
			svc.modifCant(producto.getCodigo(), cant);
		}
		
	}
	
//	solo modifica cantidad
	@Path("/items/{idProducto}")
	@PUT
	public void updateStockItemCant(@PathParam("idProducto") String id,
									@QueryParam("cant") Long cant){
		
		if(cant.intValue()>0){
			svc.modifCant(id, cant);
		}
	}
	
	@Path("/items/{idProducto}")
	@DELETE
	public void deleteStockItem(@PathParam("idProducto") String id){
		
		svc.quitarItem(id);
		
	}
	
*/

}
