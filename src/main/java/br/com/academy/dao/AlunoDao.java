package br.com.academy.dao;

import br.com.academy.model.Aluno;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AlunoDao extends JpaRepository<Aluno, Integer> {
}
