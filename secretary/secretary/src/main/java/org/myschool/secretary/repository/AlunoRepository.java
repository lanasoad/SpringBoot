package org.myschool.secretary.repository;

import java.util.List;

import org.myschool.secretary.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
	//public List<Aluno> findAllByAlunoContainingIgnoreCase(String Aluno);

}
