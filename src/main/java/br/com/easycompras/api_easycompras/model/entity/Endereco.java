package br.com.easycompras.api_easycompras.model.entity;

import br.com.easycompras.api_easycompras.model.dto.DadosAtualizacaoEndereco;
import br.com.easycompras.api_easycompras.model.dto.DadosAtualizacaoEnderecoUsuario;
import br.com.easycompras.api_easycompras.model.dto.DadosCadastroEndereco;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "EC_ENDERECOS")
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SQ_EC_ENDERECOS", sequenceName = "SQ_EC_ENDERECOS", allocationSize = 1)
	@Column(name = "CODIGO_ENDERECO")
	private Long codigoEndereco;

	@Column(name = "NUMERO", nullable = false)
	private String numero;

	@Column(name = "COMPLEMENTO")
	private String complemento;

	@Column(name = "CEP", nullable = false)
	private String cep;
	
//	public Boolean ativo;

	// CONSTRUTOR
	public Endereco() {
		super();
	}

	public Endereco(DadosCadastroEndereco dados) {
		this.numero = dados.numero();
		this.complemento = dados.complemento();
		this.cep = dados.cep();
	}

	public void atualizar(DadosAtualizacaoEndereco dados) {
		if (dados.numero() != null) {
			this.numero = dados.numero();
		}

		if (dados.complemento() != null) {
			this.complemento = dados.complemento();
		}
		
		if (dados.cep () != null ) {
			this.cep = dados.cep();
		}
	}
	
	public void atualizarEmUsuario(DadosAtualizacaoEnderecoUsuario dados) {
		if (dados.numero() != null) {
			this.numero = dados.numero();
		}

		if (dados.complemento() != null) {
			this.complemento = dados.complemento();
		}
		
		if (dados.cep () != null ) {
			this.cep = dados.cep();
		}
	}

	// GETTERS & SETTERS
	public Long getCodigoEndereco() {
		return codigoEndereco;
	}

	public void setCodigoEndereco(Long codigoEndereco) {
		this.codigoEndereco = codigoEndereco;
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

//	public void excluir() {
//		this.ativo = false;
//	}
	
	// TO STRING
	@Override
	public String toString() {
		return "Endereco " + "[codigoEndereco=" + codigoEndereco + ", numero=" + numero + ", complemento=" + complemento
				+ ", cep=" + cep + "]";
	}
}