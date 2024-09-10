package br.com.vitorgabrielti.teste_escriba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class TesteEscribaApplication {

    public static void main(String[] args) {
        SpringApplication.run(TesteEscribaApplication.class, args);
    }

}
