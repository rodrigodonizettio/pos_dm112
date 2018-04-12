package br.inatel.dm112.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "produto")
public class Produto {

	@Id
	private int numero;
	
	@Column(name="status")
	private String status;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="cpf")
	private String cpf;
	
	@Column(name="email")
	private String email;
	
	public Produto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Produto(int numero, String status, String nome, String cpf, String email) {
		super();
		this.numero = numero;
		this.status = status;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
	}
	
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	@Override
	public String toString() {
		return "Produto [numero=" + numero + ", status=" + status + ", nome=" + nome + ", cpf=" + cpf + ", email="
				+ email + "]";
	}

	
	
}
