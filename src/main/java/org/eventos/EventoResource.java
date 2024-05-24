package org.eventos;

import java.util.List;

import org.eventos.dtos.EventoDTO;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
@Path("/eventos")
public class EventoResource {

    @Inject
    EntityManager entityManager;

    @GET
    public List<Evento> eventos() {

        List<Evento> eventos = entityManager.createNamedQuery("Evento.findAll", Evento.class)
                .getResultList();

        return eventos;
    }

    
    @POST
    @Transactional
    public Response create(EventoDTO eventoDto) throws Exception {
        System.out.println("Validar os dados do DTO");
        System.out.println(eventoDto.nome);
        System.out.println(eventoDto.dataInicial);
        System.out.println(eventoDto.dataFinal);
        System.out.println(eventoDto.instituicao);

        //validacoes de datas, nome, instituicao
        if (eventoDto.dataInicial.after(eventoDto.dataFinal)) {
            return Response.status(400, "A data final deve ser posterior a data inicial").build();
        }
        if (eventoDto.instituicao == null || eventoDto.instituicao == 0) {
            return Response.status(400, "O campo Instituicao deve ser preenchido").build();
        }
        if (eventoDto.nome == null || eventoDto.nome.isEmpty()) {
            return Response.status(400, "O campo Nome deve ser preenchido") .build();
        }

        Instituicao instituicao = entityManager.find(Instituicao.class, eventoDto.instituicao);

        Evento evento = new Evento();
        evento.setAtivo(false);
        evento.setDataInicial(eventoDto.dataInicial);
        evento.setDataFinal(eventoDto.dataFinal);
        evento.setInstituicao(instituicao); 
        evento.setNome(eventoDto.nome);

        entityManager.persist(evento);
        return Response.ok(evento).status(201).build();
    }
}
