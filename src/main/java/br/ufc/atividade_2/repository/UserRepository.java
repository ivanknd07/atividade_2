package br.ufc.atividade_2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufc.atividade_2.model.UserModel;


@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {
	
	UserModel findFirstByNome(String nome);	
	
	List<UserModel> findAllByNome(String nome);
	
	//List<Product> findAllByName(String name);
	
	
	

}
