package br.com.alura.screenmatch.model;

import br.com.alura.screenmatch.model.livro.DadosLivro;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosAPI (@JsonAlias("results") List<DadosLivro> results) {

}

