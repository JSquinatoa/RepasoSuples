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
import service.IDoctorService;
import service.mapper.DoctorMapper;
import service.to.DoctorTo;
import service.to.UsuarioTo;

@Path("/doctores")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DoctorController {

    @Inject
    private IDoctorService iDoctorService;

    @GET
    @Path("/{cedula}")
    @Operation(summary = "obtener un doctor por Id", description = "Esta capacidad me permite obtener un doctor por su id (cedula)")
    public Response obtenerPorId(@PathParam("cedula") String cedula) {
        DoctorTo dTo = DoctorMapper.toTo(this.iDoctorService.buscarPorId(cedula));
        return Response.status(Response.Status.OK).entity(dTo).build();
    }

    @GET
    @Path("")
    @Operation(summary = "obtener todos los doctores", description = "Esta capacidad me permite obtener todos los doctores registrados en el sistema")
    public Response obtenerTodos() {
        List<DoctorTo> dToList = this.iDoctorService.buscarTodos().stream().map(DoctorMapper::toTo)
                .collect(Collectors.toList());
        return Response.status(Response.Status.OK).entity(dToList).build();
    }

    @POST
    @Path("")
    @Operation(summary = "guardar un doctor", description = "Esta capacidad me permite guardar un nuevo doctor en el sistema")
    public Response guardar(@RequestBody DoctorTo doctorTo) {
        this.iDoctorService.guardar(DoctorMapper.toEntity(doctorTo));
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{cedula}")
    @Operation(summary = "actualizar un doctor", description = "Esta capacidad me permite actualizar un doctor existente en el sistema")
    public Response actualizarPorId(@RequestBody DoctorTo doctorTo, @PathParam("cedula") String cedula) {
        doctorTo.setCedula(cedula);
        this.iDoctorService.actualizar(DoctorMapper.toEntity(doctorTo));
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("{cedula}")
    public Response borrarPorId(@PathParam("cedula") String cedula) {
        this.iDoctorService.borrarPorId(cedula);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @POST
    @Path("/verificacion")
    public Response verificarDoctor(@RequestBody UsuarioTo usuarioTo){
        Boolean isVerificado = this.iDoctorService.verificarDoctor(usuarioTo);
        return Response.status(Response.Status.OK).entity(isVerificado).build();
        
    }


}
