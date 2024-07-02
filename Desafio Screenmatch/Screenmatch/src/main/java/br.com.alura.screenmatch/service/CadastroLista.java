package br.com.alura.screenmatch.service;
import br.com.alura.screenmatch.principal.Principal;
import org.springframework.context.annotation.Import;
import java.util.ArrayList;
import java.util.List;

public class CadastroLista {

    public static void Cadastro(String TituloASerCadastrado, ArrayList<String> ListaASerAdicionado){
        ListaASerAdicionado.add(TituloASerCadastrado);
    }

    public static void CadastroAutor(List AutorASerCadastrado, ArrayList ListaASerAdicionado){
        ListaASerAdicionado.add(AutorASerCadastrado);
    }



}
