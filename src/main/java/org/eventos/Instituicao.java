package org.eventos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Instituicao.findAll", query = "SELECT i FROM Instituicao i ORDER BY i.id")
public class Instituicao {
    @Id
    @GeneratedValue
    public Integer id;
    public String nome;

    // @OneToMany(mappedBy="instituicao")
	// public Set<Evento> eventos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // public Set<Evento> getEventos() {
    //     return eventos;
    // }

    // public void setEventos(Set<Evento> eventos) {
    //     this.eventos = eventos;
    // }

}
