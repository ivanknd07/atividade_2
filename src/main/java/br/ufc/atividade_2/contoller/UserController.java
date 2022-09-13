package br.ufc.atividade_2.contoller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.ufc.atividade_2.model.UserModel;
import br.ufc.atividade_2.service.UserService;

@RestController
@RequestMapping(path = "/api/users")
public class UserController {

	@Autowired
	UserService service;
	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping
	public ResponseEntity<List<UserModel>> findAll() {
		return new ResponseEntity<List<UserModel>>(service.findAll(), HttpStatus.OK);
	}

	@GetMapping(path = "{id}")
	public ResponseEntity<UserModel> find(@PathVariable("id") int id) {
		return new ResponseEntity<UserModel>(service.find(id), HttpStatus.OK);
	}

	@GetMapping(path = "/search")
	public ResponseEntity<UserModel> findByNome(@RequestParam("nome") String nome) {
		UserModel usermodel = service.findByNome(nome);
		
		if(usermodel != null) {
			return new ResponseEntity<UserModel>(usermodel, HttpStatus.OK);	
		} else {
			return new ResponseEntity<UserModel>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	@PreAuthorize("hasAuthority('ADMIN')")
	public void save(@RequestBody UserModel usermodel) {
		service.save(0, usermodel);
	}

	@PutMapping(path = "{id}")
	public void update(@PathVariable("id") int id, @RequestBody UserModel usermodel) {
		service.save(id, usermodel);
	}

	@DeleteMapping(path = "{id}")
	public void delete(@PathVariable("id") int id) {
		service.delete(id);
	}
}

