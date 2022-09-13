package br.ufc.atividade_2.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.ufc.atividade_2.model.Login;
import br.ufc.atividade_2.repository.LoginRepository;

@Service
@Transactional
public class LoginService {

	@Autowired
	LoginRepository repository;

	public Login save(Login entity) {
		entity.setPassword(new BCryptPasswordEncoder().encode(entity.getPassword()));
		return repository.save(entity);
	}
	
	public List<Login> findAll() {
        return repository.findAll();
    }
}

