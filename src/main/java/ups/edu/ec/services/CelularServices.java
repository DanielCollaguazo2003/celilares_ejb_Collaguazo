package ups.edu.ec.services;

import java.util.List;
import ups.edu.ec.model.Celular;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import ups.edu.ec.business.GestionCelularLocal;


@Path("celular")
public class CelularServices {
	
	@Inject
	private GestionCelularLocal gCelular;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crear(Celular celular) {
		try{
			gCelular.guardarCelulares(celular);
			ErrorMessage error = new ErrorMessage(1, "OK");
			//return Response.ok(Celular).build();
			return Response.status(Response.Status.CREATED).entity(error).build();
		}catch (Exception e) {
			// TODO: handle exception
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(error)
					.build();
		}
	}
	

	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizar(Celular celular) {
		try{
			gCelular.actualizarCelular(celular);
			return Response.ok(celular).build();
		}catch (Exception e) {
			// TODO: handle exception
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.NOT_FOUND)
					.entity(error)
					.build();
		}
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response borrar(@QueryParam("id") int codigo) {
		try{
			gCelular.borrarCelular(codigo);
			ErrorMessage error = new ErrorMessage(1, "OK");
			return Response.status(Response.Status.CREATED).entity(error).build();
		}catch (Exception e) {
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.NOT_FOUND)
					.entity(error)
					.build();
		}
	}


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response leerPorCodigo(@QueryParam("codigo") int codigo) {
		try{
			System.out.println("id " +  codigo );
			Celular cli = gCelular.getCelularPorId(codigo);
			return Response.ok(cli).build();
		}catch (Exception e) {
			// TODO: handle exception
			ErrorMessage error = new ErrorMessage(4, "Celular no existe");
			return Response.status(Response.Status.NOT_FOUND)
					.entity(error)
					.build();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("list")
	public Response getCelular(){
		List<Celular> Celular = gCelular.getCelulares();
		if(Celular.size()>0)
			return Response.ok(Celular).build();
		
		ErrorMessage error = new ErrorMessage(6, "No se registran Celular");
		return Response.status(Response.Status.NOT_FOUND)
				.entity(error)
				.build();
		
	}

}
