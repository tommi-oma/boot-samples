package fi.digitalentconsulting.samples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class BootSamplesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootSamplesApplication.class, args);
	}
	@Autowired
	MyCounter counter;
	
	@Bean
	public ApplicationRunner joku(@Autowired MyCounter laskuri) {
		return args -> {
			System.out.println("Jotain " + laskuri.get());
			laskuri.increment();
			System.out.println("Jotain muuta" + counter.get());
		};
	}

}
