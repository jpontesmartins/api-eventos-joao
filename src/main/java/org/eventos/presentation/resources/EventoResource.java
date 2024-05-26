package org.eventos.presentation.resources;

import java.util.ArrayList;
import java.util.List;

import org.eventos.domain.dtos.EventoDTO;
import org.eventos.domain.models.EventoModel;
import org.eventos.domain.usecases.CreateEventoUseCase;
import org.eventos.domain.usecases.ListEventosUseCase;
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
    public List<EventoDTO> eventos() {
        List<EventoModel> eventos = listEventosUseCase.execute();
        
        List<EventoDTO> eventosDto = new ArrayList<EventoDTO>();
        for (EventoModel eventoModel : eventos) {
            eventosDto.add(eventoModel.toDTO());
        }
        return eventosDto;
    }

    @POST
    @Transactional
    public Response create(EventoDTO eventoDto) throws Exception {
        EventoModel eventoModel = new EventoModel(eventoDto);
        if (!eventoModel.validate()) {
            return Response.status(400, "Preencha corretamente os campos").build();
        }
        
        eventoModel = createEventoUseCase.execute(eventoModel);
        
        EventoDTO createdEventoDto = eventoModel.toDTO();

        return Response.ok(createdEventoDto).status(201).build();
    }

}
