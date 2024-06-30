package br.com.alura.screenmatch;

import br.com.alura.screenmatch.principal.Principal;
import br.com.alura.screenmatch.service.ConsumoAPI;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;


@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		while (true) {
			Scanner leitura = new Scanner(System.in);
			var principal = new Principal();
			principal.exibeMenu();
			var opcao = leitura.nextInt();

			if (opcao == 1){
				//codigo de busca do livro
				principal.opcaoUm();
			} else if (opcao == 2) {
				//codigo de listar os livros registrador

			} else if (opcao == 3) {
				//codigo de listar os autores registrados

			} else if (opcao == 4) {
				//codigo para listar os autores vivos em um determinado ano

			} else if (opcao == 5) {
				//codigo para listar os livros em um determinado idioma


			} else if (opcao == 6) {
				break;


			} else
				System.out.println("Você digitou um numero invalido por gentileza digitar um dos numeros do menu!");





        }


	}
}
