package br.com.alura.screenmatch.principal;
import br.com.alura.screenmatch.model.DadosAPI;
import br.com.alura.screenmatch.service.CadastroLista;
import br.com.alura.screenmatch.service.ConsumoAPI;
import br.com.alura.screenmatch.service.ConverteDados;
import br.com.alura.screenmatch.service.RetornoDados;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Principal {
    Scanner leitura = new Scanner(System.in);
    String URL_BASE = "https://gutendex.com/books/?search=";
    ConverteDados conversor = new ConverteDados();
    ConsumoAPI teste = new ConsumoAPI();
    CadastroLista cadastrolista = new CadastroLista();
    RetornoDados retornoDados = new RetornoDados();

    



    public void exibeMenu() {
        var menuPrincipal = """
                Escolha uma das opções:
                                
                1 - Buscar livro pelo titulo
                2 - Listar livros registrados
                3 - Listar autores registrados
                4 - Listar autores vivos em um determinado ano
                5 - Listar livros em um determinado idioma
                6 - Sair
                """;

        System.out.println(menuPrincipal);
    }

    public String OpcaoUm (String livro) {
        var json = retornoDados.opcaoUm(livro);

        DadosAPI dados = conversor.obterDados(json, DadosAPI.class);
        var Results = dados.results();
        var Consulta = Results.get(0);

        System.out.println(Consulta);

        return json;
    }

    //Metodo para retorno do Titulo
    public String OpcaoUmTitulo (String json) throws JsonProcessingException {
        return retornoDados.opcaoUmTitulo(json);
    }

    //Metodo para retorno do Nome do Autor
    public String OpcaoUmAutorNome (String json) throws JsonProcessingException {
        return retornoDados.opcaoTresAutor(json);
    }

    //Metodo para retorno da Data de morte do Autor
    public List opcaoQuatro (String json) throws JsonProcessingException {

        return retornoDados.opcaoQuatroNomeEDataMorte(json);
    }


    //Metodo para cadastro na Array
    public void opcaoDoisETres(ArrayList ListaAValidar){
        System.out.println(ListaAValidar);
    }









}
