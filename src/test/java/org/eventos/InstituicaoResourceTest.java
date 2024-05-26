package org.eventos;

import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;

import org.eventos.domain.usecases.ListInstituicoesUseCase;
import org.eventos.infra.entities.Instituicao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import java.util.ArrayList;
import java.util.List;

@QuarkusTest
class InstituicaoResourceTest {

    @InjectMock
    ListInstituicoesUseCase useCaseMock;

    @BeforeEach
    public void setup() {
        List<Instituicao> instituicoes = new ArrayList<Instituicao>();
        Instituicao instituicaoA = new Instituicao();
        instituicaoA.id = 1;
        instituicaoA.nome = "Instituicao A";
        instituicaoA.tipo = "Publica";
        instituicoes.add(instituicaoA);

        Instituicao instituicaoB = new Instituicao();
        instituicaoB.id = 2;
        instituicaoB.nome = "Instituicao B";
        instituicaoB.tipo = "Privada";
        instituicoes.add(instituicaoB);

        Mockito.when(useCaseMock.execute()).thenReturn(instituicoes);
    }

    @Test
    void should_return_instituicoes() {
        given()
                .when().get("/instituicoes")
                .then()
                .statusCode(200)
                .body(containsString("Instituicao A")).and()
                .body(containsString("Instituicao B")).and();
                
    }

}