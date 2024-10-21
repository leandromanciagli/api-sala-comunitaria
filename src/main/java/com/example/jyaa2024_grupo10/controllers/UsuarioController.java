package com.example.jyaa2024_grupo10.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.inject.Inject;
import java.util.List;
import java.util.Map;

import com.example.jyaa2024_grupo10.model.Usuario;
import com.example.jyaa2024_grupo10.service.IUsuarioService;


@Path("/usuario")
public class UsuarioController {

    @Inject
    private IUsuarioService usuarioService;

    String responseMessage;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> getAllUsuarios() {
        return usuarioService.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario getUsuarioById(@PathParam("id") Long id) {
        return usuarioService.getById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario createUsuario(Usuario usuario) {
        return usuarioService.create(usuario);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario updateUsuario(@PathParam("id") Long id, Usuario usuario) {
        usuario.setUsuarioId(id);
        return usuarioService.update(usuario);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUsuario(@PathParam("id") Long id) {
        try {
            usuarioService.delete(id);
            return Response.noContent().build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
