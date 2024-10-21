package com.example.jyaa2024_grupo10.controllers;


import com.example.jyaa2024_grupo10.model.TipoMateriaPrima;
import com.example.jyaa2024_grupo10.service.ITipoMateriaPrimaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;


@Path("/tipoMateriaPrima")
public class TipoMateriaPrimaController {

    @Inject
    private ITipoMateriaPrimaService tipoMateriaPrimaService;

    String responseMessage;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TipoMateriaPrima> getAllTipoMateriasPrimas() {
        return tipoMateriaPrimaService.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public TipoMateriaPrima getTipoMateriaPrimaById(@PathParam("id") Long id) {
        return tipoMateriaPrimaService.getById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public TipoMateriaPrima createTipoMateriaPrima(TipoMateriaPrima tipoMateriaPrima) {
        return tipoMateriaPrimaService.create(tipoMateriaPrima);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public TipoMateriaPrima updateTipoMateriaPrima(@PathParam("id") Long id, TipoMateriaPrima tipoMateriaPrima) {
        tipoMateriaPrima.setTipoMateriaPrimaId(id);
        return tipoMateriaPrimaService.update(tipoMateriaPrima);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteTipoMateriaPrima(@PathParam("id") Long id) {
        try {
            tipoMateriaPrimaService.delete(id);
            return Response.noContent().build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
