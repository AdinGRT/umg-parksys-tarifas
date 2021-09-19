package com.adingrt.api;

import com.adingrt.model.Tarifa;
import com.adingrt.service.TarifaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

/**
 *
 * @author gian_
 */

@Path("/tarifas")
public class TarifaResource {
    
    @Inject
    private TarifaService service;
    
    @GET
    @Produces("application/json")
    public Response getTarifario() {
        List<Tarifa> list = service.listarTodo();
        return Response.ok().status(Response.Status.OK).entity(list).build();
    }
    
    
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response actualizarTarifa(@PathParam("id") Integer id, Tarifa tarifa) {
        tarifa.setIdTarifa(id);
        if (service.actualizar(tarifa) == 0) {
            return Response.notModified().build();
        } else {
            return Response.ok().build();
        }
    }
    
}
