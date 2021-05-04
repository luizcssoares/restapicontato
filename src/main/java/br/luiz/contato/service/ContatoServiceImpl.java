package br.luiz.contato.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import br.luiz.contato.entity.Contato;
import br.luiz.contato.repository.ContatoRepository;

@Service
public class ContatoServiceImpl implements ContatoService{

	  @Autowired
	  private ContatoRepository repo;
	  	  
	  public List<Contato> findAll() {			  		    
		    List<Contato> lista = repo.findAll();
		    return lista;		    
	  }
	 	     
	  public void save(Contato contato) {
	        repo.save(contato);
	  }
	     
	  public Contato get(long id) {
	        return repo.findById(id).get();
	  }
	     
	  public void delete(long id) {
	        repo.deleteById(id);
	  }
}
