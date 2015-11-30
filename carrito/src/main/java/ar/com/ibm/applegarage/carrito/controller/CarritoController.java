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

import ar.com.ibm.applegarage.carrito.model.Carrito;
import ar.com.ibm.applegarage.carrito.service.CarritoService;

@Path("/carrito")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CarritoController {

	private CarritoService svc = new CarritoService();
	
//	devuelve un resumen del carrito, todavia no se en que formato, 
//	pero deberia incluir la lista de items+cantidad+total_de_linea, subtotal, tickets de promocion,
//	costo de envio, etc
	@GET
	public void getCarritoInfo(){
		
	}
	
//	recibe un objeto Carrito (quizas si el cliente lo conserva en una cookie y quisiera
//	recuperarlo al loguearse
	@POST
	public void setCarrito(Carrito carrito){
		
//		svc.setCarrito(carrito);
		
	}
	
//	devuelve los items del carrito + cantidad con su total de linea
	@Path("/items")
	@GET
	public void getCarritoItems(){
		
	}
	
	@Path("/items/{idProducto}")
	@POST
	public void addCarritoItem(@PathParam("idProducto") String id,
								@QueryParam("cant") Long cant){
		if(cant.intValue()>0){
			svc.agregarItem(id, cant);
		}else{
			svc.agregarItem(id, 1L);
		}
	}
	
	@Path("/items/{idProducto}")
	@PUT
	public void updateCarritoItemCant(@PathParam("idProducto") String id,
										@QueryParam("cant") Long cant){
		if(cant.intValue()>0){
			svc.cambiarCant(id, cant);
		}
		
	}
	
	@Path("/items/{idProducto}")
	@DELETE
	public void deleteCarritoItem(@PathParam("idProducto") String id){
		
		svc.eliminarItem(id);
	
	}
}
