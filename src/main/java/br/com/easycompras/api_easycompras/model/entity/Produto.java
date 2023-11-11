package br.com.easycompras.api_easycompras.model.entity;

import br.com.easycompras.api_easycompras.model.dto.DadosAtualizacaoProduto;
import br.com.easycompras.api_easycompras.model.dto.DadosCadastroProduto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "EC_PRODUTOS")
public class Produto 
{
	@Id
	@Column(name = "SKU")
	private String sku;

	@Column(name = "NOME_PRODUTO", nullable = false)
	private String nomeProduto;
	
	@Column(name = "DESCRICAO")
	private String descricao;
	
	// CONSTRUTORES
	public Produto() {
		super();
	}
	
	public Produto(DadosCadastroProduto dados) {
		this.sku = dados.sku();
		this.nomeProduto = dados.nomeProduto();
		this.descricao = dados.descricao();
	}
	
	public void atualizar(DadosAtualizacaoProduto dados) {
		if (dados.nomeProduto() != null) {
			this.nomeProduto = dados.nomeProduto();
		}
		
		if (dados.descricao() != null) {
			this.descricao = dados.descricao();
		}
	}
	
	// GETTERS AND SETTERS
	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	// TO STRING
	@Override
	public String toString() {
		return "Produto "
				+ "[sku=" + sku 
				+ ", nomeProduto=" + nomeProduto 
				+ ", descricao=" + descricao 
				+ "]";
	}
}
