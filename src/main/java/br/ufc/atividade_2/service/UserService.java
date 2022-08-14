package br.ufc.atividade_2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.atividade_2.model.UserModel;
import br.ufc.atividade_2.repository.UserRepository;



@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;

	public void save(int id, UserModel entity) {
        if(id != 0) {
            entity.setId(id);
        }
        userRepository.save(entity);
    }
 
    public void delete(int id) {
        UserModel userModel = find(id);
        userRepository.delete(userModel);
    }
    

    public UserModel find(int id) {
        if(id < 1) {
            return null;
        }
        
        Optional<UserModel> product = userRepository.findById(id);
        
        if(product.isPresent()) {
            return product.get();   
        }
        
        return null;        
    }
 
    public List<UserModel> findAll() {
        return userRepository.findAll();
    }
    
   public UserModel findByNome(String str) {
        if(str.length() < 3) {
            return null;
        }
        
        return userRepository.findFirstByNome(str);
    }
 
    public List<UserModel> findAllByNome(String str) {
        return userRepository.findAllByNome(str);
    }
    
}

