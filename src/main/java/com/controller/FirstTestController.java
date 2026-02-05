package com.controller;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pojo.User;



@RestController
@RequestMapping("/FirstTestController")
public class FirstTestController {

	
	@GetMapping("/getFirstMessage")
	@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
	public ResponseEntity getFirstMessage() {
		System.out.println("Dentro de getFirstMessage");
		//return new ResponseEntity("Respuesta getFirstMessage", HttpStatus.OK);
		return new ResponseEntity("{estado:exito}", HttpStatus.OK);
	}
	
	@ResponseBody
	@PostMapping(value = "/getMap")
	@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
	public Map<String,String> getMap(@RequestBody  String datoIntroducido ) {
		System.out.println("--------------Entro getMap:: "+ datoIntroducido);
		
		//Respuesta
		Map<String,String> estatusRespuestaMap = new HashMap<String,String>();
		estatusRespuestaMap.put("Estado", "Exito getMap--"+datoIntroducido);
		
		return estatusRespuestaMap;
	}
	
	
	@ResponseBody
	@PostMapping(value = "/setMap")
	@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
	public Map<String,String> setMap(@RequestBody  String datoIntroducido ) {
		System.out.println("--------------Entro setMap:: "+ datoIntroducido);
		
		//Respuesta
		Map<String,String> estatusRespuestaMap = new HashMap<String,String>();
		estatusRespuestaMap.put("Estado", "Exito setMap--"+datoIntroducido);
		
		return estatusRespuestaMap;
	}
	
	@ResponseBody
	@PostMapping(value = "/getPojo")
	@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
	public User getPojo(@RequestBody  User userIntroducido ) {
        LocalTime currentTime = LocalTime.now();
		System.out.println("--------------Entro getPojo:: "+ userIntroducido +" Current Time: " + currentTime);
		
		userIntroducido.setEdad(45);

		
		return userIntroducido;
	}
	
	@ResponseBody
	@PostMapping(value = "/getPojo2")
	@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
	public User getPojo2(@RequestBody  User userIntroducido ) {
        LocalTime currentTime = LocalTime.now();
		System.out.println("--------------Entro getPojo2:: "+ userIntroducido +" Current Time: " + currentTime);
		
		userIntroducido.setEmail("rorro2@hotmail.com");

		
		return userIntroducido;
	}
	
	@PostMapping("/getPojo3")
	@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
	public ResponseEntity getPojo3(@RequestBody  User userIntroducido) {
		System.out.println("Dentro de getPojo3:: "+userIntroducido);
		userIntroducido.setEdad(46);
		//return new ResponseEntity(userIntroducido, HttpStatus.OK);
		return new ResponseEntity(userIntroducido, HttpStatus.BAD_REQUEST);
	}
}
