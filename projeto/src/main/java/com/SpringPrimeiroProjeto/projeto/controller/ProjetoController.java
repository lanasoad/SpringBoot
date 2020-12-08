package com.SpringPrimeiroProjeto.projeto.controller;

import org.springframework.web.bind.annotation.GetMapping; // API
import org.springframework.web.bind.annotation.RequestMapping; // API
import org.springframework.web.bind.annotation.RestController; // API

@RestController
@RequestMapping ("/rota")
	public class ProjetoController {
	
	@GetMapping
	public String habilidade1 () {
		return "Uma habilidade que venho constantemente desenvolvendo, sobretudo no Módulo II, é a de Atenção aos Detalhes. "
				+ "Ela permite que eu tenha um olhar mais crítico e cauteloso para apreender caminhos, estruturas e comandos "
				+ "funcionais às, por exemplo, estruturas das API's com Spring Boot, como esta.";
	}
	@GetMapping ("/habilidade2") // criando uma subrota 1
	public String habilidade2() {
		return "Outra habilidade que tem sido tão necessária quanto é a de Trabalho em Equipe. Ela permite que interajamos uns "
				+ "com outros, principalmente quando algum erro de execução se apresenta. Isso nos permite unir e discutir sobre "
				+ "meios de solucionar, via Discord, por exemplo, erros de construção do código, ao mesmo tempo que fortalece a comunicação "
				+ "entre os colegas do grupo.";
	}
	@GetMapping ("/mentalidade1") // criando uma subrota 2
	public String mentalidade1() {
		return "Já entre as mentalidades, a de Persistência se fortalece à medida que insistimos nos exercícios e buscamos caminhos"
				+ "para resolver os erros que aparecem, complementando as experiências das habilidades acima descritas."; 
	}
	@GetMapping ("/mentalidade2") // criando uma subrota 3
	public String mentalidade2() {
		return "Por fim, a mentalidade de Responsabilidade Pessoal tem sido necessária para que, para além das atividades e estudos "
				+ "em grupo, individualmente devo buscar estudar, também em outras referências, sobre pontos apresentados em aula que"
				+ "ainda não ficaram elucidados.";
	}
}
