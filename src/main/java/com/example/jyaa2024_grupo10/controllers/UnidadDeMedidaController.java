package com.example.jyaa2024_grupo10.controllers;

import com.example.jyaa2024_grupo10.model.UnidadDeMedida;
import com.example.jyaa2024_grupo10.service.IUnidadDeMedidaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;


@Path("/unidadDeMedida")
public class UnidadDeMedidaController {

    @Inject
    private IUnidadDeMedidaService unidadDeMedidaService;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UnidadDeMedida> getAllUnidadesDeMedida() {
        return unidadDeMedidaService.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public UnidadDeMedida getUnidadDeMedidaById(@PathParam("id") Long id) {
        return unidadDeMedidaService.getById(id);
    }
}
