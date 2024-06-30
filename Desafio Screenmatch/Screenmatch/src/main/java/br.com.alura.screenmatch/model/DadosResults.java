package br.com.alura.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosResults (@JsonAlias("title") String Titulo,
                            @JsonAlias("authors") List<DadosAutor> dadosAutorList,
                            @JsonAlias("languages") List idioma,
                            @JsonAlias ("download_count") String totalDownloads)
                            {
}

