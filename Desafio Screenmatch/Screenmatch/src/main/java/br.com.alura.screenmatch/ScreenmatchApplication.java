package br.com.alura.screenmatch;

import br.com.alura.screenmatch.principal.Principal;
import br.com.alura.screenmatch.service.CadastroLista;
import br.com.alura.screenmatch.service.ConsumoAPI;
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

		while (true) {
			Scanner leitura = new Scanner(System.in);
			var principal = new Principal();
			var cadastroLista = new CadastroLista();
			String titulo = "";
			List Autor;

			principal.exibeMenu();
			var opcao = leitura.nextInt();

			if (opcao == 1){
				//codigo de busca do livro
				//titulo = principal.opcaoUmTitulo();
				principal.opcaoUmTitulo();

			} else if (opcao == 2) {
				//codigo de listar os livros registrador
				principal.opcaoDois(TitulosConsultados);

			} else if (opcao == 3) {
				//codigo de listar os autores registrados
				principal.opcaoTres(AutoresRegistrados);

			} else if (opcao == 4) {
				//codigo para listar os autores vivos em um determinado ano

			} else if (opcao == 5) {
				//codigo para listar os livros em um determinado idioma


			} else if (opcao == 6) {
				break;


			} else
				System.out.println("Você digitou um numero invalido por gentileza digitar um dos numeros do menu!");

			if (titulo != ""){
				cadastroLista.Cadastro(titulo, TitulosConsultados);
			}else
				System.out.println("Você Não cadastrou Livros");

			//CadastroLista.CadastroAutor(Autor, AutoresRegistrados);

        }


	}
}
