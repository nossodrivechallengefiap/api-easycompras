package br.com.easycompras.api_easycompras.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity(name = "Enderecos")
@Table(name = "ENDERECOS")
public class Enderecos {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SQ_ENDERECOS", sequenceName = "SQ_ENDERECOS", allocationSize = 1)
	@Column(name = "CODIGO_ENDERECO")
	private Long codigo_endereco;
	
	@Column(name = "LOGRADOURO", nullable = false)
	private String logradouro;
	
	@Column(name = "NUMERO", nullable = false)
	private String numero;
	
	@Column(name = "COMPLEMENTO")
	private String complemento;
	
	@Column(name = "BAIRRO", nullable = false)
	private String bairro;
	
	@Column(name = "CIDADE", nullable = false)
	private String cidade;
	
	@Column(name = "ESTADO", nullable = false)
	private String estado;
	
	@Column(name = "CEP", nullable = false)
	private String cep;

	// CONSTRUTOR
	public Enderecos() {
		super();
	}

	// GETTERS AND SETTERS
	public Long getCodigo_endereco() {
		return codigo_endereco;
	}

	public void setCodigo_endereco(Long codigo_endereco) {
		this.codigo_endereco = codigo_endereco;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
}
