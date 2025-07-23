package br.com.moneyflip.classes;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class AppLogic {
    private Map<String, Double> conversion_rates;

    public Map<String, Double> getConversion_rates() {
        return conversion_rates;
    }

    public static double convertido(double valor, String moedaDeOrigem, String moedaDeDestino) throws IOException, InterruptedException {
        final String url = "https://v6.exchangerate-api.com/v6/997a86da2411ac1b1e7c94d9/latest/USD";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        Gson gson = new Gson();

        // Converte o JSON pra Java
        AppLogic moeda = gson.fromJson(json, AppLogic.class);

        if (!moeda.getConversion_rates().containsKey(moedaDeOrigem)) {
            throw new IllegalArgumentException("Moeda de origem inválida.");
        }

        if (!moeda.getConversion_rates().containsKey(moedaDeDestino)) {
            throw new IllegalArgumentException("Moeda de destino inválida.");
        }

        double taxaDeOrigem = moeda.getConversion_rates().get(moedaDeOrigem);
        double taxaDeDestino = moeda.getConversion_rates().get(moedaDeDestino);
        double taxaConvertido = taxaDeDestino / taxaDeOrigem;
        return valor * taxaConvertido;
    }
}