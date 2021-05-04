package br.luiz.contato.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import br.luiz.contato.entity.Contato;

public interface ContatoService {	
	
    public List<Contato> findAll();
        
    public void save(Contato contato);
        
    public Contato get(long id);
     
    public void delete(long id);
}
