package br.com.easycompras.api_easycompras.model.entity;

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

@Entity(name = "Fornecedores")
@Table(name = "FORNECEDORES", uniqueConstraints = {
		@UniqueConstraint(columnNames = "EMAIL", name = "UK_FORNECEDORES_EMAIL")
})
public class Fornecedores {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SQ_FORNECEDORES", sequenceName = "SQ_FORNECEDORES", allocationSize = 1)
	@Column(name = "CODIGO_FORNECEDOR")
	private Long codigo_fornecedor;
	
	@Column(name = "RAZAO_SOCIAL", nullable = false)
	private String razao_social;
	
	@Column(name = "CNPJ", nullable = false)
	private String cnpj;
	
	@Column(name = "NOME_CONTATO")
	private String nome_contato;
	
	@Column(name = "TELEFONE")
	private String telefone;
	
	@Column(name = "EMAIL", nullable = false)
	private String email;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(
				name = "codigo_endereco",
				referencedColumnName = "codigo_endereco",
				foreignKey = @ForeignKey(name = "FK_FORNECEDORES_ENDERECO")
			)
	private Enderecos endereco;
	
	// CONSTRUTOR
	public Fornecedores() {
		super();
	}

	// GETTERS AND SETTERS
	public Long getCodigo_fornecedor() {
		return codigo_fornecedor;
	}

	public void setCodigo_fornecedor(Long codigo_fornecedor) {
		this.codigo_fornecedor = codigo_fornecedor;
	}

	public String getRazao_social() {
		return razao_social;
	}

	public void setRazao_social(String razao_social) {
		this.razao_social = razao_social;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome_contato() {
		return nome_contato;
	}

	public void setNome_contato(String nome_contato) {
		this.nome_contato = nome_contato;
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

	public Enderecos getEndereco() {
		return endereco;
	}

	public void setEndereco(Enderecos endereco) {
		this.endereco = endereco;
	}		
}
