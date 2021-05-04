package br.luiz.contato.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

import br.luiz.contato.enums.Profissao;

@Entity
public class Contato implements Serializable {
 
  private static final long serialVersionUID = 1L;
   
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
 
  private String cpf;
  
  private String fone;
  
  private String nome;
   
  private String email;
  
  @DateTimeFormat(pattern="dd/MM/yyyy")
  private Date data;
  
  @Enumerated(EnumType.STRING)
  private Profissao profissao;
    
  private double salario;
  
  public Contato() {
	  
  }

  public Contato(String cpf, String fone, String nome, String email, Date data, Profissao profissao, double salario) {
	 super();
	 this.cpf = cpf;
	 this.fone = fone;
	 this.nome = nome;
	 this.email = email;
	 this.data = data;
 	 this.profissao = profissao;
	 this.salario = salario;
  }

  public long getId() {
	 return id;
  }

  public void setId(long id) {
	 this.id = id;
  }

  public String getNome() {
	 return nome;
  }

  public void setNome(String nome) {
	 this.nome = nome;
  }

  public String getEmail() {
	 return email;
  }

  public void setEmail(String email) {
	 this.email = email;
  }

  public String getCpf() {
	 return cpf;
  }

  public void setCpf(String cpf) {
	 this.cpf = cpf;
  }

  public String getFone() {
	 return fone;
  }

  public void setFone(String fone) {
	 this.fone = fone;
  }

  public Date getData() {
	 return data;
  }

  public void setData(Date date) {
	 this.data = (Date) date;
  }
  
  public Profissao getProfissao() {
	 return profissao;
  }

  public void setProfissao(Profissao profissao) {
	 this.profissao = profissao;
  }

  public double getSalario() {
	 return salario;
  }

  public void setSalario(double salario) {
	 this.salario = salario;
  }
}