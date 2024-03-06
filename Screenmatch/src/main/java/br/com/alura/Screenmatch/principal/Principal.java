package br.com.alura.Screenmatch.principal;

import br.com.alura.Screenmatch.Model.DadosEpisodio;
import br.com.alura.Screenmatch.Model.DadosSerie;
import br.com.alura.Screenmatch.Model.DadosTemporada;
import br.com.alura.Screenmatch.service.ConsumoAPI;
import br.com.alura.Screenmatch.service.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private Scanner sc = new Scanner(System.in);
    private ConsumoAPI consumo = new ConsumoAPI();
    private  ConverteDados conversor = new ConverteDados();
    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=d3ba2e87";

    public void exibeMenu(){

        System.out.println("Digite o nome da série para busca");

        var nomeSerie = sc.nextLine();

        var nome = nomeSerie.replace(" ", "+");

        var json = consumo.obterDados(ENDERECO + nome + API_KEY);
        DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
        System.out.println(dados);

        List<DadosTemporada> temporadas = new ArrayList<>();

        for (int i = 1; i <= dados.totalTemporadas(); i++) {
            json = consumo.obterDados(ENDERECO + nome + "&Season=" + i + "&apikey=d3ba2e87&");

            DadosTemporada temporada = conversor.obterDados(json, DadosTemporada.class);

            temporadas.add(temporada);
        }

        temporadas.forEach(System.out::println);


        temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));

    }
}
