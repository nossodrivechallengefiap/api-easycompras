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

@Entity(name = "Usuarios")
@Table(name = "USUARIOS", uniqueConstraints = {
		@UniqueConstraint(columnNames = "EMAIL", name = "UK_USUARIOS_EMAIL")
})
public class Usuarios {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SQ_USUARIOS", sequenceName = "SQ_USUARIOS", allocationSize = 1)
	@Column(name = "CODIGO_USUARIO")
	private Long codigo_usuario;
	
	@Column(name = "NOME", nullable = false)
	private String nome;
	
	@Column(name = "SENHA", nullable = false)
	private String senha;
	
	@Column(name = "EMAIL", nullable = false)
	private String email;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(
				name = "codigo_endereco",
				referencedColumnName = "codigo_endereco",
				foreignKey = @ForeignKey(name = "FK_USUARIOS_ENDERECO")
			)
	private Enderecos endereco;
	
	//CONSTRUTORES
	public Usuarios() {
		super();
	}

	//GETTERS AND SETTERS
	public Long getCodigo_usuario() {
		return codigo_usuario;
	}

	public void setCodigo_usuario(Long codigo_usuario) {
		this.codigo_usuario = codigo_usuario;
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

	public Enderecos getEndereco() {
		return endereco;
	}

	public void setEndereco(Enderecos endereco) {
		this.endereco = endereco;
	}
}
