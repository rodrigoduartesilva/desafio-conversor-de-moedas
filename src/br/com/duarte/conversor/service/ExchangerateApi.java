package br.com.duarte.conversor.service;

import br.com.duarte.conversor.model.Conversor;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangerateApi {

    public Conversor conversorMoeda(String base_code, String target_code) {
        String key = "Your Key";
        String url = "https://v6.exchangerate-api.com/v6/" + key + "/pair/" + base_code + "/" + target_code;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {

            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), Conversor.class);

        } catch (IOException | InterruptedException error) {

            throw new RuntimeException("Moeda incorreta!");

        }
    }
}
