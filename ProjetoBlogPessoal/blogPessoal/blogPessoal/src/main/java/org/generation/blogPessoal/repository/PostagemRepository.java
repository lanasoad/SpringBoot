package org.generation.blogPessoal.repository;

import java.util.List;

import org.generation.blogPessoal.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
											//qual o tipo de entidade está sendo trabalhada (Postagem) e qual tipo de ID (Long)
@Repository // anotação que informará ao Spring que esta classe é um repositório
public interface PostagemRepository extends JpaRepository<Postagem, Long> {
	public List<Postagem> findAllByTituloContainingIgnoreCase (String titulo); // busca pelo título da postagem (parâmetro diz para buscar todos os títulos, independente de letra maiúscula
}
