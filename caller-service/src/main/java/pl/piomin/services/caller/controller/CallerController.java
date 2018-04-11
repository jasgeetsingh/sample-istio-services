package pl.piomin.services.caller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/caller")
public class CallerController {

	@Autowired
	BuildProperties buildProperties;
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/ping")
	public String ping() {
		String response = restTemplate.getForObject("http://callme-service/callme/ping", String.class);
		return buildProperties.getName() + ":" + buildProperties.getVersion() + ". Calling... " + response; 
	}
	
}
