package org.generation.blogPessoal.controller;

import java.util.List;

import org.generation.blogPessoal.model.Postagem;
import org.generation.blogPessoal.repository.PostagemRepository;
import org.generation.blogPessoal.model.Postagem;
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

@RestController // anotação que define esta classe como controller
@RequestMapping("/postagens") //define por qual URI esta classe será acessada
@CrossOrigin("*") // define que esta classe acessará requisições de qualquer origem (*)
public class PostagemController {
	
	// 1. injetar esta classe de repositório aqui no controller:
	@Autowired // uma vez que a interface não pode ser instanciada, o @autowired faz com que o Spring seja responsável por toda instanciação
	private PostagemRepository repository;
	
	// 2. Primeiro método (end-point do GET): FindAll
	@GetMapping // se o método de requisição for "GET", ele procurará em todo o repositório
	public ResponseEntity<List<Postagem>> GetAll () {
		return ResponseEntity.ok(repository.findAll());
	}
	
	// 3. Segundo método (end-point do GET): FindById
	@GetMapping("/{id}") // parâmetro que será enviado pelo requisitor
	public ResponseEntity<Postagem> GetById (@PathVariable long id) {
		return repository.findById(id) // esse método pode devolver:
				.map(resp -> ResponseEntity.ok(resp)) // um objeto do tipo postagem
				.orElse(ResponseEntity.notFound().build()); // ou "notfound", caso o objeto exista ou exista erro na requisição
	}
	
	// 4. Terceiro método (end-point do GET): FindByTitulo
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagem>> GetByTitulo (@PathVariable String titulo) {
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
	}
	
	@PostMapping // insere dados (postman)
	public ResponseEntity<Postagem> post(@RequestBody Postagem postagem) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
	}
	
	@PutMapping // // altera dados (postman)
	public ResponseEntity<Postagem> put(@RequestBody Postagem postagem) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem));
	}
	
	@DeleteMapping ("/{id}") // deleta um id (postman) 
	public void delete (@PathVariable long id ) {
		repository.deleteById(id);
	}
}
