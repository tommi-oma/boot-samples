package fi.digitalentconsulting.samples.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fi.digitalentconsulting.samples.MyCounter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/v1/hello")
public class HelloController {

	private MyCounter counter;
	
	public HelloController(@Autowired MyCounter counter) {
		this.counter = counter;
	}

	@RequestMapping("/kertoja")
	public String kertaaHei() {
		return "Hei, kertaa " + counter.increment();
	}

	@RequestMapping("/kertoja/{nimi}")
	public String nimiHei(@PathVariable(name="nimi") String nami) {
		return "Hei, " + nami;
	}

	@Operation(summary = "Get the API greet you")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "All is good",
						content = { @Content(mediaType = "text/plain",
							schema = @Schema(implementation = String.class)) }),
			@ApiResponse(responseCode = "405", description = "Illegal method",
					content = @Content)})
	@GetMapping("")
	public String sanoHei() {
		return "Terve";
	}
}
