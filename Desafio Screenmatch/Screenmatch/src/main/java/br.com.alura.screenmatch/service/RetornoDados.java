package br.com.alura.screenmatch.service;
import br.com.alura.screenmatch.model.DadosAPI;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class RetornoDados {
    String URL_BASE = "https://gutendex.com/books/?search=";
    Scanner leitura = new Scanner(System.in);
    ConverteDados conversor = new ConverteDados();
    ConsumoAPI teste = new ConsumoAPI();



    public List opcaoUm() throws JsonProcessingException {
        System.out.println("Digite o nome do livro que deseja buscar");

        //Declaração de Var e Arrays
        var livro = leitura.nextLine();
        var json = teste.obterDados(URL_BASE + livro);

        //Modelagem Dados API
        DadosAPI dados = conversor.obterDados(json, DadosAPI.class);

        var Results = dados.results();
        var Consulta = Results.get(0);
        String titulo = Consulta.Titulo();
        List autor = Consulta.dadosAutorList();
        var nome = autor.get(0);
        System.out.println(nome);

        return autor;
    }

}
