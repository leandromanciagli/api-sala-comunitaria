package com.example.jyaa2024_grupo10.controllers;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.inject.Inject;
import java.util.List;
import com.example.jyaa2024_grupo10.model.ProductoraAgricola;
import com.example.jyaa2024_grupo10.service.IProductoraAgricolaService;


@Path("/productoraAgricola")
public class ProductoraAgricolaController {

    @Inject
    private IProductoraAgricolaService productoraAgricolaService;

    String responseMessage;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductoraAgricola> getAllProductorasAgricolas() {
        return productoraAgricolaService.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ProductoraAgricola getProductoraAgricolaById(@PathParam("id") Long id) {
        return productoraAgricolaService.getById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ProductoraAgricola createProductoraAgricola(ProductoraAgricola productoraAgricola) {
        return productoraAgricolaService.create(productoraAgricola);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ProductoraAgricola updateProductoraAgricola(@PathParam("id") Long id, ProductoraAgricola productoraAgricola) {
        productoraAgricola.setProductoraAgricolaId(id);
        return productoraAgricolaService.update(productoraAgricola);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteProductoraAgricola(@PathParam("id") Long id) {
        try {
            productoraAgricolaService.delete(id);
            return Response.noContent().build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
