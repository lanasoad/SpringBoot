package com.ecommerce.eletro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.eletro.model.TipoEletro;
import com.ecommerce.eletro.repository.TipoEletroRepository;

@RestController
@RequestMapping("/TipoEletro")
@CrossOrigin(value = "*", allowedHeaders = "*")
public class TipoEletroController {

	@Autowired
	private TipoEletroRepository repository;

	@GetMapping
	public ResponseEntity<List<TipoEletro>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<TipoEletro> GetById(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<TipoEletro> post(@RequestBody TipoEletro eletro) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(eletro));
	}

	@PutMapping
	public ResponseEntity<TipoEletro> put(@RequestBody TipoEletro eletro) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(eletro));
	}

	@DeleteMapping
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}

}
