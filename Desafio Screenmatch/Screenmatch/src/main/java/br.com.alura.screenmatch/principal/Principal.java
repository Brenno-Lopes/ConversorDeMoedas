package br.com.alura.screenmatch.principal;
import br.com.alura.screenmatch.model.DadosAPI;
import br.com.alura.screenmatch.model.DadosTitle;
import br.com.alura.screenmatch.service.CadastroLista;
import br.com.alura.screenmatch.service.ConsumoAPI;
import br.com.alura.screenmatch.service.ConverteDados;
import br.com.alura.screenmatch.service.RetornoDados;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Principal {
    Scanner leitura = new Scanner(System.in);
    String URL_BASE = "https://gutendex.com/books/?search=";
    ConverteDados conversor = new ConverteDados();
    ConsumoAPI teste = new ConsumoAPI();
    CadastroLista cadastrolista = new CadastroLista();

    



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



    public void opcaoUmTitulo() throws JsonProcessingException {
        var consultaDados = new RetornoDados();
        var autor = consultaDados.opcaoUm();
        System.out.println(autor);
        autor.get(1);
        autor.get(2);

    }

    //public String opcaoUmAutor() throws JsonProcessingException {

    //}



    //opcaoDois
    public void opcaoDois(ArrayList ListaAValidar){
        System.out.println(ListaAValidar);
    }

    //opcaoTres
    public void opcaoTres(List ListaAValidar){
        System.out.println(ListaAValidar);
    }







}
