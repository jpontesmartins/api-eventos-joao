package org.eventos;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
@Path("/instituicoes")
public class InstituicaoResource {

    @Inject
    EntityManager entityManager;

    @GET
    public List<Instituicao> instituicoes() {

        List<Instituicao> instituicoes = entityManager.createNamedQuery("Instituicao.findAll", Instituicao.class)
                .getResultList();
        return instituicoes;
    }
}
