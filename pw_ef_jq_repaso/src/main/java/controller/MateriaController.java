package controller;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import service.IMateriaService;
import service.mapper.MateriaDTOMapper;
import service.mapper.MateriaMapper;
import service.to.MateriaDTOTo;
import service.to.MateriaTo;

@Path("/materias")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MateriaController {

    @Inject
    private IMateriaService iMateriaService;

    @GET
    @Path("")
    public Response obtenerTodos(@Context UriInfo uriInfo) {
        List<MateriaDTOTo> mDTOToList = this.iMateriaService.obtenerTodos()
                .stream()
                .map(MateriaDTOMapper::toTo)
                .peek(materia -> materia.buidlURI(uriInfo))
                .collect(Collectors.toList());
        return Response.status(Response.Status.OK).entity(mDTOToList).build();
    }

    @POST
    @Path("")
    public Response guardarMateria(@RequestBody MateriaTo materiaTo) {
        this.iMateriaService.guardar(MateriaMapper.toEntity(materiaTo));
        return Response.status(Response.Status.CREATED).build();
    }

    @DELETE
    @Path("/{id}")
    public Response eliminarPorId(@PathParam("id") Integer id) {
        this.iMateriaService.borrarPorId(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @GET
    @Path("/{id}")
    public Response obtenerPorId(@PathParam("id") Integer id) {
        MateriaTo mTo = MateriaMapper.toTo(this.iMateriaService.obtenerPorId(id));
        return Response.status(Response.Status.OK).entity(mTo).build();
    }

}
