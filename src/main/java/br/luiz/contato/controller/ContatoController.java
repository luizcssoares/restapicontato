package br.luiz.contato.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.luiz.contato.entity.Contato;
import br.luiz.contato.repository.ContatoRepository;
import br.luiz.contato.service.ContatoService;

@RestController
public class ContatoController {
   
  @Autowired
  private ContatoService service;
     
  @RequestMapping(value="/api/contato", method = RequestMethod.GET)  
  //public ResponseEntity<List<Contato>> listar() {
  public ResponseEntity<?> listar() {
	  List<Contato> lista = null;  		
	  lista = service.findAll(); 
	  return new ResponseEntity<List<Contato>>(lista, new HttpHeaders(), HttpStatus.OK); 
	  //return new ResponseEntity<>(lista, new HttpHeaders(), HttpStatus.OK);
  }
 
  @RequestMapping(value="/api/contato/{id}", method=RequestMethod.GET)
  public ResponseEntity<?> findContato(@PathVariable(name = "id") long id) {
	  try {
	      Contato contato = service.get(id);	     
	      return ResponseEntity.ok(contato);	      
	  } catch (NoSuchElementException e) {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	  }      
  }
    
  @RequestMapping(value = "/api/contato", method = RequestMethod.POST)
  public void saveContato(@RequestBody Contato contato) {
	  SimpleDateFormat formaDate = new SimpleDateFormat("dd/MM/yyyy");
      String data = formaDate.format(contato.getData());	  
      try {
		contato.setData(formaDate.parse(data));
	  } catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	  }
      service.save(contato);             
  }
  
  @RequestMapping(value="/api/contato/{id}", method=RequestMethod.PUT)
  public ResponseEntity<?> editContato(@RequestBody Contato frmcontato, @PathVariable(name = "id") long id) {
	  try {
	      Contato contato = service.get(id);
	      service.save(frmcontato);
	      return new ResponseEntity<>(HttpStatus.OK);
	  } catch (NoSuchElementException e) {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	  }      
  }
  
  @RequestMapping(value="/api/contato/{id}", method=RequestMethod.DELETE)
  public void deleteContato(@PathVariable(name = "id") long id) {      
      service.delete(id);      
  }
}