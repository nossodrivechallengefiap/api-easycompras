package br.com.easycompras.api_easycompras.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity(name = "Produtos")
@Table(name = "PRODUTOS")
public class Produtos {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SQ_PRODUTOS", sequenceName = "SQ_PRODUTOS", allocationSize = 1)
	@Column(name = "SKU")
	private String sku;

	@Column(name = "NOME_PRODUTO", nullable = false)
	private String nome_produto;
	
	//CONSTRUTORES
	public Produtos() {
		super();
	}

	//GETTERS AND SETTERS
	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getNome_produto() {
		return nome_produto;
	}

	public void setNome_produto(String nome_produto) {
		this.nome_produto = nome_produto;
	}
}
