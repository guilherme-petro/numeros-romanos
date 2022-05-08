package com.studiosol.palavraRomana.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studiosol.palavraRomana.repository.PalavraRomanaRepository;

@RestController
@RequestMapping("/search")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PalavraController {
	
	public String number;
	public int value;
	
	PalavraRomanaRepository repository;
	
	@PostMapping
	public String receberPalavra(@RequestBody String text) {
		
		ArrayList<String> nRom = new ArrayList<>(); 
		nRom = repository.separarNumeros(text);
		
		int[] val = new int[nRom.size()];
		val = repository.converterNumeros(nRom);
		
		return 	"number: " + number + "\n" +
				"value: " + value;
		
	}

	

}
