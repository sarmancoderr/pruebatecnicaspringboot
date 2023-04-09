package es.sarman.pruebatecnica;

import es.sarman.pruebatecnica.Heroes.Hero;
import es.sarman.pruebatecnica.Heroes.HeroRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableWebSecurity
public class PruebatecnicaApplication {

	private Logger logger = LoggerFactory.getLogger(PruebatecnicaApplication.class);

	@Autowired
	private HeroRepository heroRepository;

	@Value("${greet}")
	public String greet;

	public static void main(String[] args) {
		SpringApplication.run(PruebatecnicaApplication.class, args);
	}

	@GetMapping("/greet")
	public String greet() {
		return greet;
	}

	@Bean
	InitializingBean sendDatabase() {
		return () -> {
			logger.info("FILLING DB");
			heroRepository.save(new Hero("Superman"));
			heroRepository.save(new Hero("Batman"));
			heroRepository.save(new Hero("Manolito el fuerte"));
		};
	}
}
