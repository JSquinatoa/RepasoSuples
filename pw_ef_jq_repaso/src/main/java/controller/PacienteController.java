package controller;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import service.IPacienteService;
import service.mapper.PacienteMapper;
import service.to.PacienteTo;

@Path("/pacientes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PacienteController {

    @Inject
    private IPacienteService iPacienteService;

    @POST
    @Path("")
    public Response guardarPaciente (@RequestBody PacienteTo pacienteTo){
        this.iPacienteService.guardar(PacienteMapper.toEntity(pacienteTo));
        return Response.status(Response.Status.CREATED).build();
    }

}
