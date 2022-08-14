package br.ufc.atividade_2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.atividade_2.model.AnuncioModel;
import br.ufc.atividade_2.model.UserModel;
import br.ufc.atividade_2.repository.AnuncioRepository;
import br.ufc.atividade_2.repository.UserRepository;




@Service
public class AnuncioService {
	
	@Autowired
	AnuncioRepository anuncioRepository;
	
	@Autowired
	UserRepository userRepository;

	public void update(int id, AnuncioModel entity) {
        AnuncioModel anuncioModel = find(id);
        anuncioModel.setTitulo(entity.getTitulo());
        anuncioModel.setEndereco(entity.getEndereco());
        anuncioModel.setMetros_quadr(entity.getMetros_quadr());
        anuncioModel.setMetros_constr(entity.getMetros_constr());
        anuncioModel.setQtd_quartos(entity.getQtd_quartos());
        anuncioModel.setQtd_banheiros(entity.getQtd_banheiros());
        anuncioModel.setQtd_vag_gar(entity.getQtd_vag_gar());
        anuncioModel.setPreco(entity.getPreco());
        anuncioModel.setStatus(entity.getStatus());
        
        anuncioRepository.save(anuncioModel);              
    }
	
	public void save(int user_id, AnuncioModel entity) {
		UserModel userModel = userRepository.findById(user_id).get();
		entity.setUserModel(userModel);
		anuncioRepository.save(entity);
	}
	

    public void delete(int id) {
        AnuncioModel anuncioModel = find(id);
        anuncioRepository.delete(anuncioModel);
    }
    
    
    public AnuncioModel find(int id) {
        if(id < 1) {
            return null;
        }
        
        Optional<AnuncioModel> anunciModel = anuncioRepository.findById(id);
        
        if(anunciModel.isPresent()) {
            return anunciModel.get();   
        }
        
        return null;        
    }
    
 
    public List<AnuncioModel> findAll() {
        return anuncioRepository.findAll();
    }
    
    
   /* public List<AnuncioModel> findAll(int product_id) {
        return anuncioRepository.findByAnuncioImovelId(product_id);
    }*/
    
   
    /* public AnuncioModel findByNome(String str) {
        if(str.length() < 3) {
            return null;
        }
        
        return anuncioRepository.findFirstByNome(str);
    }
 
    public List<AnuncioModel> findAllByNome(String str) {
        return anuncioRepository.findAllByNome(str);
    }*/

}
