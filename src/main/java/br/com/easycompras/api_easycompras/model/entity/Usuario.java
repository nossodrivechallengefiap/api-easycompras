package br.com.easycompras.api_easycompras.model.entity;

import br.com.easycompras.api_easycompras.model.dto.DadosAtualizacaoUsuario;
import br.com.easycompras.api_easycompras.model.dto.DadosCadastroUsuario;
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
@Table(name = "EC_USUARIOS", uniqueConstraints = {
		@UniqueConstraint(columnNames = "EMAIL", name = "UK_EC_USUARIOS_EMAIL")
})
public class Usuario 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SQ_EC_USUARIOS", sequenceName = "SQ_EC_USUARIOS", allocationSize = 1)
	@Column(name = "CODIGO_USUARIO")
	private Long codigoUsuario;
	
	@Column(name = "NOME", nullable = false)
	private String nome;
	
	@Column(name = "SENHA", nullable = false)
	private String senha;
	
	@Column(name = "EMAIL", nullable = false)
	private String email;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(
				name = "CODIGO_ENDERECO",
				referencedColumnName = "CODIGO_ENDERECO",
				foreignKey = @ForeignKey(name = "FK_USUARIOS_ENDERECOS")
			)
	private Endereco endereco;
	
	//CONSTRUTORES
	public Usuario() {
		super();
	}
	
	public Usuario(DadosCadastroUsuario dados) {
		this.nome = dados.nome();
		this.senha = dados.senha();
		this.email = dados.email();
		this.endereco = new Endereco(dados.endereco());
	}
	
	public void atualizar(DadosAtualizacaoUsuario dados) {
		if (dados.nome() != null) {
			this.nome = dados.nome();
		}
		
		if (dados.senha() != null) {
			this.senha = dados.senha();
		}
		
		if (dados.email() != null) {
			this.email = dados.email();
		}
		
		if (dados.endereco() != null) {
			this.endereco.atualizarEmUsuario(dados.endereco());
		}
	}

	//GETTERS AND SETTERS
	public Long getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(Long codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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
	public String toString() 
	{
		return "Usuario ["
				+ "codigoUsuario=" + codigoUsuario 
				+ ", nome=" + nome 
				+ ", senha=" + senha 
				+ ", email=" + email
				+ ", endereco=" + endereco 
				+ "]";
	}
}
