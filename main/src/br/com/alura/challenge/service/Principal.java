package br.com.alura.challenge.service;
import br.com.alura.challenge.model.Moedas;
import java.util.Scanner;


public class Principal {
    public static void main(String[] args) {
        /*Variaveis*/

        int opcao = 0;

        Scanner scanner = new Scanner(System.in);

        String menu = """
                 Bem vindo ao Conversor de Moedas, por gentileza escreva a opção que dejesa converter
                1) Dólar =>> Peso Argentino"
                2) Peso Argentino =>> Dólar"
                3) Dólar =>> Real brasileiro"
                4) Real brasileiro =>> Dólar"
                5) Dólar =>> Peso colombiano"
                6) Peso colombiano =>> Dólar"
                7) Sair
                *****************************************
                """;

        while (opcao != 7) {
            Moedas consultarMoeda = new Moedas();
            ConsultaMoeda consultaMoeda = new ConsultaMoeda();
//          ConsultaMoeda solicitarMoeda = new ConsultaMoeda();
            String link = "https://v6.exchangerate-api.com/v6/d7c843e29c98a5e36352935a/pair/";
            String moeda;
            double valorASerConvertido = 0.00;
            System.out.println(menu);
            opcao = scanner.nextInt();

            if (opcao == 1) {
                moeda = consultarMoeda.getDolarParaArgentino();
                double consulta = consultaMoeda.buscaMoeda(link + moeda);
                System.out.println("Digite o Valor a ser convertido " + moeda);
                valorASerConvertido = scanner.nextDouble();
                System.out.println("O valor convertido é $" + valorASerConvertido * consulta);

                break;

            } else if (opcao == 2) {
                moeda = consultarMoeda.getPesoArgentinoParaDolar();
                double consulta = consultaMoeda.buscaMoeda(link + moeda);
                System.out.println("Digite o Valor a ser convertido US$" + moeda);
                valorASerConvertido = scanner.nextDouble();
                System.out.println("O Valor convertido é " + valorASerConvertido * consulta);

                break;

            } else if (opcao == 3) {
                moeda = consultarMoeda.getDolarParaRealBrasileiro();
                double consulta = consultaMoeda.buscaMoeda(link + moeda);
                System.out.println("Digite o Valor a ser convertido " + moeda);
                valorASerConvertido = scanner.nextDouble();
                System.out.println("O valor convertido é R$" + valorASerConvertido * consulta);
                break;

            } else if (opcao == 4) {
                moeda = consultarMoeda.getRealBrasileiroParaDolar();
                double consulta = consultaMoeda.buscaMoeda(link + moeda);
                System.out.println("Digite o Valor a ser convertido " + moeda);
                valorASerConvertido = scanner.nextDouble();
                System.out.println("O valor convertido é US$" + valorASerConvertido * consulta);
                break;

            } else if (opcao == 5) {
                moeda = consultarMoeda.getDolarParaPesoColombiano();
                double consulta = consultaMoeda.buscaMoeda(link + moeda);
                System.out.println("Digite o Valor a ser convertido " + moeda);
                valorASerConvertido = scanner.nextDouble();
                System.out.println("O valor convertido é $" + valorASerConvertido * consulta);
                break;

            } else if (opcao == 6) {
                moeda = consultarMoeda.getPesoColombianoParaDolar();
                double consulta = consultaMoeda.buscaMoeda(link + moeda);
                System.out.println("Digite o Valor a ser convertido " + moeda);
                valorASerConvertido = scanner.nextDouble();
                System.out.println("O valor convertido é US$" + valorASerConvertido * consulta);
                break;

            } else if (opcao == 7) {
                System.out.println("Obrigado por usar o nosso conversor! \n Have a Good Day!");
                break;

            } else
                System.out.println("Opção Invalida, por gentileza digitar uma das opções informadas anteriormente.\n");

        if (opcao != 7) {
            System.out.println("Obrigado por utilizar nossa aplicação");
        }

        }
    }
}

