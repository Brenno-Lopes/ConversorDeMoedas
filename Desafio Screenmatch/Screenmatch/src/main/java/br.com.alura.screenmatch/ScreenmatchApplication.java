package br.com.alura.screenmatch;

import br.com.alura.screenmatch.principal.Principal;
import br.com.alura.screenmatch.service.CadastroLista;
import br.com.alura.screenmatch.service.ConsumoAPI;
import br.com.alura.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ArrayList<String> TitulosConsultados = new ArrayList<>();
		ArrayList<String> AutoresRegistrados = new ArrayList<>();
		ArrayList<List> DataMorteDosAutores = new ArrayList<>();

		while (true) {

			//Variaveis
			Scanner leitura = new Scanner(System.in);
			var principal = new Principal();
			var cadastroLista = new CadastroLista();
			String titulo = "";
			String autor = "";
			List datamorte;

			//Escolha do Menu
			principal.exibeMenu();
			int opcao = leitura.nextInt();



			//Configuração do retorno para o usuario.
			if (opcao == 1){
				//Identificação do livro
				System.out.println("Digite o nome do livro que deseja buscar");
				var livro = leitura.next();


				//API
				var retornoAPI = principal.OpcaoUm(livro);

				//Declaração de Var e Arrays
				titulo = principal.OpcaoUmTitulo(retornoAPI);
				autor = principal.OpcaoUmAutorNome(retornoAPI);
				datamorte = principal.opcaoQuatro(retornoAPI);
				if (titulo != ""){
					cadastroLista.Cadastro(titulo, TitulosConsultados);
					cadastroLista.Cadastro(autor, AutoresRegistrados);
					cadastroLista.CadastroList(datamorte, DataMorteDosAutores);
				}

			} else if (opcao == 2) {
				//codigo de listar os livros registrador
				if (TitulosConsultados.size() != 0){
					principal.opcaoDoisETres(TitulosConsultados);
				}else System.out.println("Nenhum livro Cadastrado");

			} else if (opcao == 3) {
				//codigo de listar os autores registrados
				if (TitulosConsultados.size() != 0){
					principal.opcaoDoisETres(AutoresRegistrados);
				}else System.out.println("Nenhum Autor Cadastrado");

			} else if (opcao == 4) {
				//codigo para listar os autores vivos em um determinado ano
				if (TitulosConsultados.size() != 0){

				}else System.out.println("Nenhum Autor Cadastrado");

			} else if (opcao == 5) {
				//codigo para listar os livros em um determinado idioma


			} else if (opcao == 6) {
				break;


			} else
				System.out.println("Você digitou um numero invalido por gentileza digitar um dos numeros do menu!");

        }


	}
}
