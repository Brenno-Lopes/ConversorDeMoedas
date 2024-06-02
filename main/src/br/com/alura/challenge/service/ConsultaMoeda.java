package br.com.alura.challenge.service;
import br.com.alura.challenge.model.Dados;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;



public class ConsultaMoeda {
    double consulta;

    public double buscaMoeda(String conversor) {
//        String moedas = "";
//        moedas.valueOf(moedaSolicitada);
//        URI moeda = URI.create("https://v6.exchangerate-api.com/v6/d7c843e29c98a5e36352935a/pair/" + moedas);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(conversor))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
//            return new Gson().fromJson(response.body(), Dados.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String json = response.body();

        Gson gson = new Gson();
        Dados dadosJson = gson.fromJson(json, Dados.class);
        return consulta = dadosJson.conversao();
    }



}