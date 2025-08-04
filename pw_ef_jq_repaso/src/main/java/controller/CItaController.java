package controller;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import service.ICitaService;
import service.mapper.CitaMapper;
import service.to.CitaTo;

@Path("/citas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CItaController {

    @Inject
    private ICitaService iCitaService;

    @GET
    @Path("")
    public Response obtenerTodos() {
        List<CitaTo> cToList = this.iCitaService.buscarTodos().stream().map(CitaMapper::toTo)
                .collect(Collectors.toList());
        return Response.status(Response.Status.OK).entity(cToList).build();
    }

    @POST
    @Path("")
    public Response guardarCita(@RequestBody CitaTo citaTo){
        this.iCitaService.guardar(CitaMapper.toEntity(citaTo));
        return Response.status(Response.Status.CREATED).build();
    }

}
