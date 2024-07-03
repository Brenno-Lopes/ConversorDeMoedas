package br.com.alura.screenmatch.service;
import br.com.alura.screenmatch.principal.Principal;
import org.springframework.context.annotation.Import;
import java.util.ArrayList;
import java.util.List;

public class CadastroLista {

    public static void Cadastro(String stringASerCadastrado, ArrayList<String> ListaASerAdicionado){
        ListaASerAdicionado.add(stringASerCadastrado);
    }

    public static void CadastroList(List listASerCadastrado, ArrayList listaASerAdicionado){
        listaASerAdicionado.add(listASerCadastrado);
    }



}
