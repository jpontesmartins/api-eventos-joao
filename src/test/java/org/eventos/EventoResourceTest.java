package org.eventos;

import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eventos.domain.dtos.EventoDTO;
import org.eventos.domain.usecases.CreateEventoUseCase;
import org.eventos.domain.usecases.ListEventosUseCase;
import org.eventos.infra.entities.Evento;
import org.eventos.infra.entities.Instituicao;

@QuarkusTest
class EventoResourceTest {

    @InjectMock
    ListEventosUseCase listEventos;

    @InjectMock
    CreateEventoUseCase createEvento;

    @BeforeEach
    public void setup() {
        List<Evento> eventos = new ArrayList<Evento>();
        Evento evento = new Evento();
        evento.setAtivo(false);
        evento.setDataInicial(new Date());
        evento.setDataFinal(new Date());
        evento.setId(1);
        evento.setNome("Nome do evento");

        Instituicao instituicao = new Instituicao();
        instituicao.setId(1);
        instituicao.setNome("Alguma Instituicao");
        evento.setInstituicao(instituicao);
        eventos.add(evento);

        Mockito.when(listEventos.execute()).thenReturn(eventos);

        Mockito.when(createEvento.execute(any())).thenReturn(evento);

    }

    @Test
    void should_return_list_of_events() {
        given()
                .when().get("/eventos")
                .then()
                .statusCode(200)
                .assertThat()
                .body(containsString("Nome do evento")).and()
                .body(containsString("dataInicial")).and()
                .body(containsString("dataFinal"));

    }

    @Test
    void should_return_created_event() {
        EventoDTO eventoDto = new EventoDTO();
        eventoDto.ativo = false;
        eventoDto.dataInicial = new Date();
        eventoDto.dataFinal = new Date();
        eventoDto.instituicao = 1;
        eventoDto.nome = "Nome do Evento";

        given()
                .contentType(ContentType.JSON)
                .when().body(eventoDto)
                .post("/eventos")
                .then()
                .body(containsString("Alguma Instituicao")).and()
                .body(containsString("Nome do evento")).and();

    }

    @Test
    void should_return_error_DTO_without_nome() {
        EventoDTO eventoDto = new EventoDTO();
        eventoDto.ativo = false;
        eventoDto.dataInicial = new Date();
        eventoDto.dataFinal = new Date();
        eventoDto.instituicao = 1;

        given()
                .contentType(ContentType.JSON)
                .when().body(eventoDto)
                .post("/eventos")
                .then().statusCode(400);

    }

    @Test
    void should_return_error_DTO_without_instituicao() {
        EventoDTO eventoDto = new EventoDTO();
        eventoDto.ativo = false;
        eventoDto.dataInicial = new Date();
        eventoDto.dataFinal = new Date();
        eventoDto.nome = "Nome";

        given()
                .contentType(ContentType.JSON)
                .when().body(eventoDto)
                .post("/eventos")
                .then().statusCode(400);

    }

    @Test
    void should_return_error_DTO_without_dataInicial() {
        EventoDTO eventoDto = new EventoDTO();
        eventoDto.ativo = false;
        eventoDto.dataFinal = new Date();
        eventoDto.instituicao = 1;

        given()
                .contentType(ContentType.JSON)
                .when().body(eventoDto)
                .post("/eventos")
                .then().statusCode(400);

    }

    @Test
    void should_return_error_DTO_without_dataFinal() {
        EventoDTO eventoDto = new EventoDTO();
        eventoDto.ativo = false;
        eventoDto.dataInicial = new Date();
        eventoDto.instituicao = 1;

        given()
                .contentType(ContentType.JSON)
                .when().body(eventoDto)
                .post("/eventos")
                .then().statusCode(400);

    }



}