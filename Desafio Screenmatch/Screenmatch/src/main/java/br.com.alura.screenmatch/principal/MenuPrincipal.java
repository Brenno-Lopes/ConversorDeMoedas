package br.com.alura.screenmatch.principal;
import br.com.alura.screenmatch.model.autor.Autor;
import br.com.alura.screenmatch.model.livro.Livro;
import br.com.alura.screenmatch.modelBanco.EntidadeAutor;
import br.com.alura.screenmatch.modelBanco.EntidadeLivro;
import br.com.alura.screenmatch.service.RetornoDados;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;


public class MenuPrincipal {
    Scanner leitura = new Scanner(System.in);
    RetornoDados retornoDados = new RetornoDados();

    private final EntidadeLivro repositorioLivro;
    private final EntidadeAutor repositorioAutor;

    public MenuPrincipal(EntidadeLivro repositorioLivro, EntidadeAutor repositorioAutor) {
        this.repositorioLivro = repositorioLivro;
        this.repositorioAutor = repositorioAutor;
    }

    public void exibeMenu() throws JsonProcessingException {
        int opcao = 999;


        while (opcao != 0) {
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
            opcao = leitura.nextInt();

            //Escolha do Menu
            if (opcao == 1) {
                //Identificação do livro
                System.out.println("Digite o nome do livro que deseja buscar");
                var livroRecebido = leitura.next();
                var livro = livroRecebido.replace(" ", "%20");
                retornoDados.OpcaoUm(livro);

            } else if (opcao == 2) {
                //codigo de listar os livros registrador
                List<Livro> livrosNaBase = repositorioLivro.livrosCadastrados();
                livrosNaBase.forEach(System.out::println);

            } else if (opcao == 3) {
                //codigo de listar os autores registrados
                List<Autor> autoresNaBase = repositorioAutor.autoresCadastrados();
                autoresNaBase.forEach(System.out::println);

                } else if (opcao == 4) {
                //codigo para listar os autores vivos em um determinado ano
                //variaveis
                int anoConsulta;


                System.out.println("Informe o ano que deseja consultar");
                anoConsulta = leitura.nextInt();

                List<Autor> autoresNaBase = repositorioAutor.autoresVivosNaqueleAno(anoConsulta);
                if(!autoresNaBase.isEmpty()){
                    autoresNaBase.forEach(System.out::println);
                }
                else{
                    System.out.println("Não foi identificado um Autor falecido dentro do ano informado");
                }

                } else if (opcao == 5) {
                //codigo para listar os livros em um determinado idioma
                String idioma;
                System.out.println("""
                                Informe o Idioma que deseja consultar
                                pt para Português
                                en para Inglês""");


                leitura.nextLine();
                idioma = leitura.nextLine();

                List<Livro> livrosPorIdioma = repositorioLivro.livrosCadastrados();

                List<Livro> livrosFiltrados = livrosPorIdioma.stream().filter(livro -> livro.getIdioma().contains(idioma)).toList();

                if(!livrosFiltrados.isEmpty()){
                    livrosFiltrados.forEach(System.out::println);
                }
                else{
                    System.out.println("Não existe nenhum livro neste idioma em nosso banco de dados.");
                }
                break;



            } else if (opcao == 6) {
                break;


            } else
                System.out.println("Você digitou um numero invalido por gentileza digitar um dos numeros do menu!");

        }


    }
}
