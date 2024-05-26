package org.eventos.presentation.resources;

import java.util.List;

import org.eventos.domain.dtos.EventoDTO;
import org.eventos.domain.usecases.CreateEventoUseCase;
import org.eventos.domain.usecases.ListEventosUseCase;
import org.eventos.infra.entities.Evento;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
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
    CreateEventoUseCase createEventoUseCase;

    @Inject
    ListEventosUseCase listEventosUseCase;

    @GET
    public List<Evento> eventos() {
        List<Evento> eventos = listEventosUseCase.execute();
        return eventos;
    }

    @POST
    @Transactional
    public Response create(EventoDTO eventoDto) throws Exception {
        if (!this.validateDto(eventoDto)) {
            return Response.status(400, "Preencha corretamente os campos").build();
        }

        Evento evento = createEventoUseCase.execute(eventoDto);

        return Response.ok(evento).status(201).build();
    }

    private boolean validateDto(EventoDTO eventoDto) {
        if (eventoDto.dataInicial == null || eventoDto.dataFinal == null 
                || eventoDto.dataInicial.after(eventoDto.dataFinal)) {
            return false;
        }
        if (eventoDto.instituicao == null || eventoDto.instituicao == 0) {
            return false;
        }
        if (eventoDto.nome == null || eventoDto.nome.isEmpty()) {
            return false;
        }
        return true;
    }
}
