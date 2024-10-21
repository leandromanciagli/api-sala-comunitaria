package com.example.jyaa2024_grupo10.controllers;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.inject.Inject;
import java.util.List;
import com.example.jyaa2024_grupo10.model.MateriaPrima;
import com.example.jyaa2024_grupo10.service.IMateriaPrimaService;


@Path("/materiaPrima")
public class MateriaPrimaController {

    @Inject
    private IMateriaPrimaService materiaPrimaService;

    String responseMessage;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<MateriaPrima> getAllMateriasPrimas() {
        return materiaPrimaService.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MateriaPrima getMateriaPrimaById(@PathParam("id") Long id) {
        return materiaPrimaService.getById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public MateriaPrima createMateriaPrima(MateriaPrima materiaPrima) {
        return materiaPrimaService.create(materiaPrima);
    }

    @PATCH
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public MateriaPrima updateMateriaPrima(@PathParam("id") Long id, MateriaPrima materiaPrima) {
        materiaPrima.setMateriaPrimaId(id);
        return materiaPrimaService.update(materiaPrima);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteMateriaPrima(@PathParam("id") Long id) {
        try {
            materiaPrimaService.delete(id);
            return Response.noContent().build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

 /*       MateriaPrima materiaPrima = materiaPrimaService.getById(id);
        if (materiaPrima != null) {
            materiaPrimaService.delete(materiaPrima);
            responseMessage = "Se eliminó correctamente la materia prima " + id;
            return Response.status(Response.Status.OK)
                    .entity("{\"mensaje\": \"" + responseMessage + "\"}")
                    .build();
        } else {
            responseMessage = "No existe la materia prima con id" + id;
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("{\"mensaje\": \"" + responseMessage + "\"}")
                    .build();
        }*/
    }
}
