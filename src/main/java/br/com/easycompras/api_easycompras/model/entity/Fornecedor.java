package br.com.easycompras.api_easycompras.model.entity;

import br.com.easycompras.api_easycompras.model.dto.DadosAtualizacaoFornecedor;
import br.com.easycompras.api_easycompras.model.dto.DadosAtualizacaoFornecedorSemPK;
import br.com.easycompras.api_easycompras.model.dto.DadosCadastroFornecedor;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "EC_FORNECEDORES", uniqueConstraints = {
		@UniqueConstraint(columnNames = "EMAIL", name = "UK_EC_FORNECEDORES_EMAIL")
})
public class Fornecedor {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SQ_EC_FORNECEDORES", sequenceName = "SQ_EC_FORNECEDORES", allocationSize = 1)
	@Column(name = "CODIGO_FORNECEDOR")
	private Long codigoFornecedor;
	
	@Column(name = "RAZAO_SOCIAL", nullable = false)
	private String razaoSocial;
	
	@Column(name = "CNPJ", nullable = false)
	private String cnpj;
	
	@Column(name = "NOME_CONTATO")
	private String nomeContato;
	
	@Column(name = "TELEFONE")
	private String telefone;
	
	@Column(name = "EMAIL", nullable = false)
	private String email;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(
				name = "CODIGO_ENDERECO",
				referencedColumnName = "CODIGO_ENDERECO",
				foreignKey = @ForeignKey(name = "FK_FORNECEDOR_ENDERECOS")
			)
	private Endereco endereco;
	
	// CONSTRUTOR
	public Fornecedor() {
		super();
	}
	
	public Fornecedor(DadosCadastroFornecedor dados) {
		this.razaoSocial = dados.razaoSocial();
		this.cnpj = dados.cnpj();
		this.nomeContato = dados.nomeContato();
		this.telefone = dados.telefone();
		this.email = dados.email();
		this.endereco = new Endereco(dados.endereco());
	}
	
	public void atualizar(DadosAtualizacaoFornecedor dados) {
		if (dados.razaoSocial() != null ) {
			this.razaoSocial = dados.razaoSocial();
		}
		
		if (dados.cnpj() != null ) {
			this.cnpj = dados.cnpj();
		}
		
		if (dados.nomeContato() != null ) {
			this.nomeContato = dados.nomeContato();
		}
		
		if (dados.telefone() != null ) {
			this.telefone = dados.telefone();
		}
		
		if (dados.email() != null) {
			this.email = dados.email();
		}
		
		if (dados.endereco() != null) {
			this.endereco.atualizarSemPK(dados.endereco());
		}
	}
	
	public void atualizarSemPK(DadosAtualizacaoFornecedorSemPK dados) {
		if (dados.razaoSocial() != null ) {
			this.razaoSocial = dados.razaoSocial();
		}
		
		if (dados.cnpj() != null ) {
			this.cnpj = dados.cnpj();
		}
		
		if (dados.nomeContato() != null ) {
			this.nomeContato = dados.nomeContato();
		}
		
		if (dados.telefone() != null ) {
			this.telefone = dados.telefone();
		}
		
		if (dados.email() != null) {
			this.email = dados.email();
		}
		
		if (dados.endereco() != null) {
			this.endereco.atualizarSemPK(dados.endereco());
		}
	}

	// GETTERS AND SETTERS
	public Long getCodigoFornecedor() {
		return codigoFornecedor;
	}

	public void setCodigoFornecedor(Long codigoFornecedor) {
		this.codigoFornecedor = codigoFornecedor;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNomeContato() {
		return nomeContato;
	}

	public void setNomeContato(String nomeContato) {
		this.nomeContato = nomeContato;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	// TO STRING
	@Override
	public String toString() {
		return "Fornecedor ["
				+ "codigoFornecedor=" + codigoFornecedor 
				+ ", razaoSocial=" + razaoSocial 
				+ ", cnpj=" + cnpj
				+ ", nomeContato=" + nomeContato 
				+ ", telefone=" + telefone 
				+ ", email=" + email 
				+ ", endereco="	+ endereco 
				+ "]";
	}
}
