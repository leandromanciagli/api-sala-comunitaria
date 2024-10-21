package com.example.jyaa2024_grupo10.controllers;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.inject.Inject;
import java.util.List;
import com.example.jyaa2024_grupo10.model.IngresoMateriaPrima;
import com.example.jyaa2024_grupo10.service.IIngresoMateriaPrimaService;


@Path("/ingresoMateriaPrima")
public class IngresoMateriaPrimaController {

    @Inject
    private IIngresoMateriaPrimaService ingresoMateriaPrimaService;

    String responseMessage;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<IngresoMateriaPrima> getAllIngresosMateriaPrima() {
        return ingresoMateriaPrimaService.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public IngresoMateriaPrima getIngresoMateriaPrimaById(@PathParam("id") Long id) {
        return ingresoMateriaPrimaService.getById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public IngresoMateriaPrima createIngresoMateriaPrima(IngresoMateriaPrima ingresoMateriaPrima) {
        return ingresoMateriaPrimaService.create(ingresoMateriaPrima);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public IngresoMateriaPrima updateIngresoMateriaPrima(@PathParam("id") Long id, IngresoMateriaPrima ingresoMateriaPrima) {
        ingresoMateriaPrima.setIngresoMateriaPrimaId(id);
        return ingresoMateriaPrimaService.update(ingresoMateriaPrima);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteIngresoMateriaPrima(@PathParam("id") Long id) {
        try {
            ingresoMateriaPrimaService.delete(id);
            return Response.noContent().build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
