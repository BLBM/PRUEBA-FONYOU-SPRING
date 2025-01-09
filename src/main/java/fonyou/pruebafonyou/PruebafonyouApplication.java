package fonyou.pruebafonyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PruebafonyouApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebafonyouApplication.class, args);
	}

}
