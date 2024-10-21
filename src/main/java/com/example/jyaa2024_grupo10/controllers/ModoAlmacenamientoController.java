package com.example.jyaa2024_grupo10.controllers;

import com.example.jyaa2024_grupo10.model.ModoAlmacenamiento;
import com.example.jyaa2024_grupo10.service.IModoAlmacenamientoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;


@Path("/modoAlmacenamiento")
public class ModoAlmacenamientoController {

    @Inject
    private IModoAlmacenamientoService modoAlmacenamientoService;

    String responseMessage;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ModoAlmacenamiento> getAllModosAlmacenamiento() {
        return modoAlmacenamientoService.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ModoAlmacenamiento getModoAlmacenamientoById(@PathParam("id") Long id) {
        return modoAlmacenamientoService.getById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ModoAlmacenamiento createModoAlmacenamiento(ModoAlmacenamiento modoAlmacenamiento) {
        return modoAlmacenamientoService.create(modoAlmacenamiento);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ModoAlmacenamiento updateModoAlmacenamiento(@PathParam("id") Long id, ModoAlmacenamiento modoAlmacenamiento) {
        modoAlmacenamiento.setModoAlmacenamientoId(id);
        return modoAlmacenamientoService.update(modoAlmacenamiento);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteModoAlmacenamiento(@PathParam("id") Long id) {
        try {
            modoAlmacenamientoService.delete(id);
            return Response.noContent().build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
