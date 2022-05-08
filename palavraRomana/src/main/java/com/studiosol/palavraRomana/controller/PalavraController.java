package com.studiosol.palavraRomana.controller;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studiosol.palavraRomana.model.PalavraModel;
import com.studiosol.palavraRomana.model.ValoresModel;
import com.studiosol.palavraRomana.repository.PalavraRomanaRepository;

@RestController
@RequestMapping("/search")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PalavraController {
	
	private String text;	
	private ArrayList<String> nRom = new ArrayList<>();	
	private PalavraRomanaRepository repository;
	private ValoresModel valores;

	@PostMapping
	public ResponseEntity<ValoresModel> receberPalavra(@RequestBody PalavraModel palavra) {

		repository = new PalavraRomanaRepository();
		valores = new ValoresModel();
		
		text = repository.converteString(palavra);
		nRom = repository.separarNumeros(text);
		repository.converterNumeros(nRom);
		valores = repository.valores();

		return ResponseEntity.ok(valores);
	}

}
