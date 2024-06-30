package br.com.alura.screenmatch.principal;
import br.com.alura.screenmatch.model.DadosAPI;
import br.com.alura.screenmatch.model.DadosResults;
import br.com.alura.screenmatch.service.ConsumoAPI;
import br.com.alura.screenmatch.service.ConverteDados;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Scanner;



public class Principal {
    Scanner leitura = new Scanner(System.in);
    String URL_BASE = "https://gutendex.com/books/?search=";
    ConverteDados conversor = new ConverteDados();
    ConsumoAPI teste = new ConsumoAPI();



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

    public void opcaoUm() throws JsonProcessingException {
        System.out.println("Digite o nome do livro que deseja buscar");

        //Declaração de Var e Arrays
        var livro = leitura.nextLine();
        var json = teste.obterDados(URL_BASE + livro);
        ObjectMapper mapper = new ObjectMapper();
        List Results;
        String livroAPI;

        //Modelagem Dados API
        DadosAPI dados = conversor.obterDados(json, DadosAPI.class);
        Results = dados.results();


          livroAPI = String.valueOf(Results.get(0));
          System.out.println(livroAPI);
//
//        DadosResults resultado = conversor.obterDados(livroAPI, DadosResults.class);
//        var teste = String.valueOf(resultado);
//
//
//        System.out.println(resultado);
//        System.out.println(teste);

        //converção dos Dados do Results


        //converção dos Dados Ator


    }



}
