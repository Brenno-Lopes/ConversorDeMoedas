package br.com.alura.screenmatch.service;
import br.com.alura.screenmatch.model.livro.DadosLivro;
import com.fasterxml.jackson.core.JsonProcessingException;
public class RetornoDados {
    String URL_BASE = "https://gutendex.com/books/?search=";
    ConverteDados conversor = new ConverteDados();
    ConsumoAPI consumoAPI = new ConsumoAPI();


    public void OpcaoUm (String livro) throws JsonProcessingException {
        //Realiza a Consulta na API
        var json = consumoAPI.obterDados(URL_BASE + livro);

        //Converte os dados da API
        DadosLivro dados = conversor.converterDados(json);

        System.out.println(dados);
    }

//    public String opcaoTresAutor(String json) throws JsonProcessingException {
//
//        //Modelagem Dados API
//        DadosAPI dados = conversor.obterDados(json, DadosAPI.class);
//        var Results = dados.results();
//        var Consulta = Results.get(0);
//        var autor = Consulta.dadosAutorList();
//        var nome = autor.get(0);
//
//        return nome.nome();
//    }
//
//    public List opcaoQuatroNomeEDataMorte(String json) throws JsonProcessingException {
//
//        //Modelagem Dados API
//        DadosAPI dados = conversor.obterDados(json, DadosAPI.class);
//
//        var Results = dados.results();
//        var Consulta = Results.get(0);
//        List Autor = Consulta.dadosAutorList();
//        return Autor;
//    }
//
//    public List opcaoCincoIdioma(String json) throws JsonProcessingException {
//
//        //Modelagem Dados API
//        DadosAPI dados = conversor.obterDados(json, DadosAPI.class);
//
//        var Results = dados.results();
//        var Consulta = Results.get(0);
//        var Idioma = Consulta.idioma();
//
//        return Idioma;
//    }

}
