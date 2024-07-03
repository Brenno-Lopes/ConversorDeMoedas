package br.com.alura.screenmatch.service;
import br.com.alura.screenmatch.model.DadosAPI;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.ArrayList;
import java.util.List;
public class RetornoDados {
    String URL_BASE = "https://gutendex.com/books/?search=";
    ConverteDados conversor = new ConverteDados();
    ConsumoAPI teste = new ConsumoAPI();

    public String opcaoUm(String livro) {
        return teste.obterDados(URL_BASE + livro);
    }


    public String opcaoUmTitulo(String json) throws JsonProcessingException {

        //Modelagem Dados API
        DadosAPI dados = conversor.obterDados(json, DadosAPI.class);
        var Results = dados.results();
        var Consulta = Results.get(0);

        return Consulta.Titulo();
    }

    public String opcaoTresAutor(String json) throws JsonProcessingException {

        //Modelagem Dados API
        DadosAPI dados = conversor.obterDados(json, DadosAPI.class);
        var Results = dados.results();
        var Consulta = Results.get(0);
        var autor = Consulta.dadosAutorList();
        var nome = autor.get(0);

        return nome.nome();
    }

    public List opcaoQuatroNomeEDataMorte(String json) throws JsonProcessingException {

        //Modelagem Dados API
        DadosAPI dados = conversor.obterDados(json, DadosAPI.class);

        var Results = dados.results();
        var Consulta = Results.get(0);
        List Autor = Consulta.dadosAutorList();
        System.out.println(Autor);
        return Autor;
    }

    public List opcaoCincoIdioma(String json) throws JsonProcessingException {

        //Modelagem Dados API
        DadosAPI dados = conversor.obterDados(json, DadosAPI.class);

        var Results = dados.results();
        var Consulta = Results.get(0);
        var Idioma = Consulta.idioma();

        return Idioma;
    }

}
