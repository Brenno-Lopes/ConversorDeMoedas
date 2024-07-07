package br.com.alura.screenmatch.model.autor;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosAutor(int id,
                         @JsonAlias ("name") String nome,
                         @JsonAlias ("birth_year") int dataNascimento,
                         @JsonAlias ("death_year") int dataMorte) {
}
