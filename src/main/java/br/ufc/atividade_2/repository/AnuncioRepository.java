package br.ufc.atividade_2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufc.atividade_2.model.AnuncioModel;



@Repository
public interface AnuncioRepository extends JpaRepository<AnuncioModel, Integer>{
	
	//List<AnuncioModel> findByUserModelId(int id);

	//UserModel findFirstByNome(String nome);

	//List<UserModel> findAllByNome(String nome);
	
	//List<AnuncioModel> findByAnuncioImovelId(int id);

}
