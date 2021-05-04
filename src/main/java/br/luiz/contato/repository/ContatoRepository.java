package br.luiz.contato.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import br.luiz.contato.entity.Contato;

//public interface ContatoRepository extends PagingAndSortingRepository<Contato, Long>{
public interface ContatoRepository extends JpaRepository<Contato, Long>{
	
	@Query(value="Select * from Contato e Where e.nome LIKE %:searchTerm%", nativeQuery=true)
	Page<Contato> search(@Param("searchTerm") String searchTerm, Pageable pageable);
	
	@Query(value="Select * from Contato", nativeQuery=true)
	public List<Contato> findAll();	

}
