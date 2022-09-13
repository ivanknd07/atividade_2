package br.ufc.atividade_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufc.atividade_2.model.Login;

public interface LoginRepository extends JpaRepository<Login, Integer> {
	Login findByEmail(String email);

}
