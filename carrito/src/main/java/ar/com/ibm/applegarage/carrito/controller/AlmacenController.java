package ar.com.ibm.applegarage.carrito.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import ar.com.ibm.applegarage.carrito.model.Producto;
import ar.com.ibm.applegarage.carrito.service.AlmacenService;

@Path("/stock")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AlmacenController {

	
	AlmacenService svc = new AlmacenService();
	
	@Path("/items")
	@GET
	public void getStockItems(){
		
	}
	
	@Path("/items")
	@POST
	public void addStockItem(Producto producto,
								@QueryParam("cant") Long cant){
		if (cant.intValue()<=0){
			cant = 1L;
		}
		svc.agregarItem(producto, cant.intValue());
		
	}
	
	
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
	
}
