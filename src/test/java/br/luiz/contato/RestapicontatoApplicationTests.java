package br.luiz.contato;

import java.util.Date;

import javax.validation.ConstraintViolationException;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.luiz.contato.entity.Contato;
import br.luiz.contato.enums.Profissao;
import br.luiz.contato.repository.ContatoRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
class RestapicontatoApplicationTests {

	@Autowired
	private ContatoRepository contatoRepository;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void saveShouldPersistData() {		
		Contato contato = new Contato ("66666666","8523545","Joao Jose","joao@gmail.com",new Date(), Profissao.valueOf("ADVOGADO"), 10.20);
		this.contatoRepository.save(contato);
		Assertions.assertThat(contato.getId()).isNotNull();
		Assertions.assertThat(contato.getCpf()).isEqualTo("66666666");
		Assertions.assertThat(contato.getFone()).isEqualTo("8523545");
		Assertions.assertThat(contato.getNome()).isEqualTo("Joao Jose");
		Assertions.assertThat(contato.getEmail()).isEqualTo("joao@gmail.com");
		Assertions.assertThat(contato.getData()).isNotNull();
		Assertions.assertThat(contato.getProfissao()).isNotNull();
		Assertions.assertThat(contato.getSalario()).isNotNull();
	}
	
	@Test
	public void deleteShouldPersistData() {		
		Contato contato = new Contato ("66666666","8523545","Joao Jose","joao@gmail.com",new Date(), Profissao.valueOf("ADVOGADO"), 10.20);
		this.contatoRepository.save(contato);
		this.contatoRepository.delete(contato);
		Assertions.assertThat(this.contatoRepository.findById(contato.getId())).isNotNull();
	}
	
	@Test
	public void updateShouldChangeAndPersistData() {		
		Contato contato = new Contato ("66666666","8523545","Joao Jose","joao@gmail.com",new Date(), Profissao.valueOf("ADVOGADO"), 10.20);
		this.contatoRepository.save(contato);
		contato.setNome("Juvania");	
		contato = this.contatoRepository.save(contato);		
		Assertions.assertThat(contato.getNome()).isEqualTo("Juvania");
	}
	

}
