package controller;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import service.IDoctorService;
import service.mapper.DoctorMapper;
import service.to.DoctorTo;

@Path("/doctores")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DoctorController {

    @Inject
    private IDoctorService iDoctorService;

    @POST
    @Path("")
    public Response guardarDoctor(@RequestBody DoctorTo doctorTo) {
        this.iDoctorService.guardar(DoctorMapper.toEntity(doctorTo));
        return Response.status(Response.Status.CREATED).build();
    }

}
