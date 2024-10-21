package com.example.jyaa2024_grupo10.controllers;

import com.example.jyaa2024_grupo10.model.Rol;
import com.example.jyaa2024_grupo10.service.IRolService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import io.swagger.v3.oas.annotations.*;


import java.util.List;


@Path("/rol")
public class RolController {

    @Inject
    private IRolService rolService;

    String responseMessage;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Rol> getAllRol() {
        return rolService.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Rol getRolById(@PathParam("id") Long id) {
        return rolService.getById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Rol createRol(Rol rol) {
        return rolService.create(rol);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Rol updateRol(@PathParam("id") Long id, Rol rol) {
        rol.setRolId(id);
        return rolService.update(rol);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteRol(@PathParam("id") Long id) {
        try {
            rolService.delete(id);
            return Response.noContent().build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
