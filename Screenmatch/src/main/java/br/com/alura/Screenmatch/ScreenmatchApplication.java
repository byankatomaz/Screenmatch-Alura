package br.com.alura.Screenmatch;

import br.com.alura.Screenmatch.Model.DadosEpisodio;
import br.com.alura.Screenmatch.Model.DadosSerie;
import br.com.alura.Screenmatch.Model.DadosTemporada;
import br.com.alura.Screenmatch.principal.Principal;
import br.com.alura.Screenmatch.service.ConsumoAPI;
import br.com.alura.Screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.exibeMenu();
	}



}
