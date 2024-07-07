package br.com.alura.screenmatch.service;
import br.com.alura.screenmatch.model.livro.DadosLivro;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConverteDados {

    public DadosLivro converterDados(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        var mapear = mapper.readTree(json);
        var LivroResults = mapear.get("results").get(0);

        return mapper.treeToValue(LivroResults, DadosLivro.class);
    }
}
