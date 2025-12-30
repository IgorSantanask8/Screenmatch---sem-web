package br.com.alura.screenmatch;

import br.com.alura.screenmatch.models.DadoSerie;
import br.com.alura.screenmatch.services.ConsumoApi;
import br.com.alura.screenmatch.services.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        var consumoApi = new ConsumoApi();
        var json = consumoApi.ObterDados("http://www.omdbapi.com/?apikey=92d7e30c&t=gilmore+girls");
        System.out.println(json);

        ConverteDados conversor = new ConverteDados();
        DadoSerie dados = conversor.ObterDados(json, DadoSerie.class);
        System.out.println(dados);


    }
}
