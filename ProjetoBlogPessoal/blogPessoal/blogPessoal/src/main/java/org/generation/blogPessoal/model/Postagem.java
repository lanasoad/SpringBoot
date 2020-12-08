package org.generation.blogPessoal.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity // define o comportamento de "entidade" do JPA HIBERNATE desta classe Postagem 
@Table(name = "Postagem") // no banco de dados, esta entidade virará uma tabela chamada "Postagem"
public class Postagem {
	
	@Id // na postagem, estes dados serão ID's
	@GeneratedValue (strategy = GenerationType.IDENTITY) // o modo como o ID se comportará no DB (será gerado e transformado numa primary key)
	private long id;
	
	@NotNull // anotação que determina que o título não pode ficar em branco
	@Size (min = 5, max = 100)  // determina a qtde de caracter enviados pelo cliente como "título"
	private String titulo;
	
	@NotNull // anotação que determina que o texto não pode ficar em branco
	@Size (min = 5, max = 500)  // determina a qtde de caracter enviados pelo cliente como "texto"
	private String texto;
	
	@Temporal (TemporalType.TIMESTAMP) // anotação que indicará ao JPA HIBERNATE que estaremos trabalhando com o tempo
	private Date data = new java.sql.Date(System.currentTimeMillis()); // método que demonstrará a data e a hora exata em que o dado passou por esta classe
	
	//getters e setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	

}
