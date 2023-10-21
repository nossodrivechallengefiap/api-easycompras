package br.com.easycompras.api_easycompras.model.entity;

import java.time.LocalDateTime;

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

@Entity(name = "Solicitacoes")
@Table(name = "SOLICITACOES")
public class Solicitacoes {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SQ_SOLICITACOES", sequenceName = "SQ_SOLICITACOES", allocationSize = 1)
	@Column(name = "CODIGO_SOLICITACAO")
	private Long codigo_solicitacao;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(
				name = "codigo_cotacao",
				referencedColumnName = "codigo_cotacao",
				foreignKey = @ForeignKey(name = "FK_SOLICITACOES_COTACAO")
			)
	private Cotacoes cotacao_aprovada;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(
				name = "sku",
				referencedColumnName = "sku",
				foreignKey = @ForeignKey(name = "FK_SOLICITACOES_PRODUTO")
			)
	private Produtos produto;
	
	@Column(name = "QUANTIDADE", nullable = false)
	private Long quantidade;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(
				name = "codigo_usuario",
				referencedColumnName = "codigo_usuario",
				foreignKey = @ForeignKey(name = "FK_SOLICITACOES_SOLICITANTE")
			)
	private Usuarios solicitante;
	
	@Column(name = "DATA_SOLICITACAO", nullable = false)
	private LocalDateTime data_solicitacao;
	
	// CONSTRUTORES
	public Solicitacoes() {
		super();
	}

	//GETTERS AND SETTERS
	public Long getCodigo_solicitacao() {
		return codigo_solicitacao;
	}

	public void setCodigo_solicitacao(Long codigo_solicitacao) {
		this.codigo_solicitacao = codigo_solicitacao;
	}

	public Cotacoes getCotacao_aprovada() {
		return cotacao_aprovada;
	}

	public void setCotacao_aprovada(Cotacoes cotacao_aprovada) {
		this.cotacao_aprovada = cotacao_aprovada;
	}

	public Produtos getProduto() {
		return produto;
	}

	public void setProduto(Produtos produto) {
		this.produto = produto;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public Usuarios getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Usuarios solicitante) {
		this.solicitante = solicitante;
	}

	public LocalDateTime getData_solicitacao() {
		return data_solicitacao;
	}

	public void setData_solicitacao(LocalDateTime data_solicitacao) {
		this.data_solicitacao = data_solicitacao;
	}
}
