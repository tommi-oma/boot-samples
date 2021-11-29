package fi.tieturi.esim.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import fi.digitalentconsulting.samples.MyCounter;

@Configuration
@Profile("!test")
public class CounterConfiguration {
	@Value("${my.counter.value:7}") //optional default (:7)
	private int value;
	
	@Bean
	@Primary
	public MyCounter configMyCounter() {
		MyCounter counter = new MyCounter();
		counter.set(value);
		return counter;
	}
}