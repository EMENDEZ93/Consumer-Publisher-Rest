package publisher.rest.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import publisher.rest.domain.dto.ObjectDto;

@CrossOrigin
@RestController
public class PublisherRestController {

	@GetMapping
	public String getPublisher() {
		return "** get Publisher **";
	}

	@PostMapping
	public String postPublisher(@Valid @RequestBody ObjectDto object) {
		return "** sent object -> " + object.getName();
	}	
	
}
