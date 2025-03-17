package org.example.controller;


import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.persistence.entity.AuthorEntity;
import org.example.service.AuthorService;

import java.util.List;


@Path("/authors") // URL base para este recurso
@Produces(MediaType.APPLICATION_JSON) // Respuesta en formato JSON
@Consumes(MediaType.APPLICATION_JSON) // Acepta datos en formato JSON
public class AuthorController {

    @Inject
    private AuthorService authorService;

    // Endpoint para obtener todos los autores
    @GET
    public Response getAllAuthors() {
        List<AuthorEntity> authors = authorService.getAllAuthors();
        return Response.ok(authors).build();
    }

    // Endpoint para obtener un autor por ID
    @GET
    @Path("/{id}")
    public Response getAuthorById(@PathParam("id") Long id) {
        AuthorEntity author = authorService.getAuthorById(id);
        if (author == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Author not found with ID: " + id)
                    .build();
        }
        return Response.ok(author).build();
    }
}
