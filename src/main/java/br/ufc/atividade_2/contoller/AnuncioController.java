package br.ufc.atividade_2.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.ufc.atividade_2.model.AnuncioModel;
import br.ufc.atividade_2.service.AnuncioService;




@RestController
@RequestMapping(path = "/api")
public class AnuncioController {
	
	@Autowired
	AnuncioService service;
	
	@GetMapping
	public ResponseEntity<List<AnuncioModel>> findAll() {
		return new ResponseEntity<List<AnuncioModel>>(service.findAll(), HttpStatus.OK);
	}
	
	 @GetMapping("/users/{id}/anuncios")
	    public ResponseEntity<List<AnuncioModel>> findAll(@PathVariable(value = "id") int id) {
	        return new ResponseEntity<List<AnuncioModel>>(service.findAll(), HttpStatus.OK);
	  }
	
	
		@GetMapping("/anuncios/{id}")
		public ResponseEntity<AnuncioModel> find(@PathVariable("id") int id) {
			return new ResponseEntity<AnuncioModel>(service.find(id), HttpStatus.OK);
		}

	/*@GetMapping(path = "/search")
	public ResponseEntity<AnuncioModel> findByNome(@RequestParam("nome") String nome) {
		AnuncioModel anunciomodel = service.findByNome(nome);
		
		if(anunciomodel != null) {
			return new ResponseEntity<AnuncioModel>(anunciomodel, HttpStatus.OK);	
		} else {
			return new ResponseEntity<AnuncioModel>(HttpStatus.NOT_FOUND);
		}
	}*/

	
	@PostMapping("/users/{id}/anuncios")
    public void save(@PathVariable("id") int user_id, @RequestBody AnuncioModel anuncioModel) {
        service.save(user_id, anuncioModel);
    }


	@PutMapping("/anuncios/{id}")
    public void update(@PathVariable("id") int id, @RequestBody AnuncioModel anuncioModel) {
        service.update(id, anuncioModel);
    }

	
	@DeleteMapping("/anuncios/{id}")
	public void delete(@PathVariable("id") int id) {
		service.delete(id);
	}

}
