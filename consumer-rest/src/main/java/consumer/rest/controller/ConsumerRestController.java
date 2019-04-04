package consumer.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import consumer.rest.domain.service.UtilService;

@CrossOrigin
@RestController
public class ConsumerRestController {

	@Autowired
	private UtilService utilService;
	
	
	@GetMapping
	public String getConsumer() {
		utilService.consummingExternalService();
		return "** getConsumer ***";
	}

}
