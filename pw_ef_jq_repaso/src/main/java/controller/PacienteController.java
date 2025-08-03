package controller;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import service.IPacienteService;
import service.mapper.PacienteMapper;
import service.to.PacienteTo;

@Path("/pacientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PacienteController {

    @Inject
    private IPacienteService iPacienteService;

    // cajon
    @GET
    @Path("/{cedula}")
    @Operation(
        summary = "Buscar paciente por cédula",
        description = "Esta capacidad permite buscar un paciente utilizando su cédula"
    )
    public Response buscarPorCedula(@PathParam("cedula") String cedula){
        PacienteTo pTo = PacienteMapper.toTo(this.iPacienteService.buscarPorCedula(cedula));
        return Response.status(Response.Status.OK).entity(pTo).build();
    }

    @GET
    @Path("")
    @Operation(
        summary = "Buscar todos los pacientes",
        description = "Esta capacidad permite buscar todos los pacientes"
    )
    public Response buscarTodos(){
        List<PacienteTo> pToList = this.iPacienteService.buscarTodos().stream().map(PacienteMapper::toTo).collect(Collectors.toList());
        return Response.status(Response.Status.OK).entity(pToList).build();
    }

    @POST
    @Path("")
    @Operation(
        summary = "Guardar paciente",
        description = "Esta capacidad permite guardar un paciente"
    )
    public Response guardar(@RequestBody PacienteTo pacienteTo){
        this.iPacienteService.guardar(PacienteMapper.toEntity(pacienteTo));
        return Response.status(Response.Status.CREATED).build();
    }


    // opcionales

    @GET
    @Path("{id}")
    @Operation(
        summary = "Buscar paciente por ID",
        description = "Esta capacidad permite buscar un paciente utilizando su ID"
    )
    public Response buscarPorId(@PathParam("id") Integer id){
        PacienteTo pTo = PacienteMapper.toTo(this.iPacienteService.buscarPorId(id));
        return Response.status(Response.Status.OK).entity(pTo).build();
    }

    @PUT
    @Path("/{id}")
    @Operation(
        summary = "Actualizar paciente por ID",
        description = "Esta capacidad permite actualizar un paciente utilizando su ID"
    )
    public Response actualizarPorId(@RequestBody PacienteTo pacienteTo, @PathParam("id") Integer id){
        pacienteTo.setId(id);
        this.iPacienteService.actualizar(PacienteMapper.toEntity(pacienteTo));
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("{cedula}")
    @Operation(
        summary = "Borrar paciente por cédula",
        description = "Esta capacidad permite borrar un paciente utilizando su cédula"
    )
    public Response borrarPorCedula(@PathParam("cedula") String cedula){
        this.iPacienteService.borrarPorCedula(cedula);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

}
