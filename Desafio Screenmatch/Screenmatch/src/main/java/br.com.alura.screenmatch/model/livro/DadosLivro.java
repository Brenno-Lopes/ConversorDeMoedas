package br.com.alura.screenmatch.model.livro;

import br.com.alura.screenmatch.model.autor.DadosAutor;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosLivro(int id,
                         @JsonAlias("title") String Titulo,
                         @JsonAlias("authors") List<DadosAutor> dadosAutorList,
                         @JsonAlias("languages") List<String> idioma,
                         @JsonAlias ("download_count") int totalDownloads) {
}

