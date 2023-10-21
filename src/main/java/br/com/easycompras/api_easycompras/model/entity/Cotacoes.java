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

@Entity(name = "Cotacoes")
@Table(name = "COTACOES")
public class Cotacoes {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SQ_COTACOES", sequenceName = "SQ_COTACOES", allocationSize = 1)
	@Column(name = "CODIGO_COTACAO")
	private Long codigo_cotacao;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(
				name = "codigo_solicitacao",
				referencedColumnName = "codigo_solicitacao",
				foreignKey = @ForeignKey(name = "FK_COTACOES_SOLICITACAO")
			)
	private Solicitacoes solicitacao;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(
				name = "codigo_fornecedor",
				referencedColumnName = "codigo_fornecedor",
				foreignKey = @ForeignKey(name = "FK_COTACOES_FORNECEDOR")
			)
	private Fornecedores fornecedor;
	
	@Column(name = "VALOR_UNITARIO", nullable = false)
	private Long VALOR_UNITARIO;
	
	@Column(name = "DATA_ENTREGA_PREVISTA")
	private LocalDateTime DATA_ENTREGA_PREVISTA;
	
	@Column(name = "DATA_COTACAO", nullable = false)
	private LocalDateTime DATA_COTACAO;
	
	// CONSTRUTOR
	public Cotacoes() {
		super();
	}

	// GETTERS AND SETTERS
	public Long getCodigo_cotacao() {
		return codigo_cotacao;
	}

	public void setCodigo_cotacao(Long codigo_cotacao) {
		this.codigo_cotacao = codigo_cotacao;
	}

	public Solicitacoes getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(Solicitacoes solicitacao) {
		this.solicitacao = solicitacao;
	}

	public Fornecedores getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedores fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Long getVALOR_UNITARIO() {
		return VALOR_UNITARIO;
	}

	public void setVALOR_UNITARIO(Long vALOR_UNITARIO) {
		VALOR_UNITARIO = vALOR_UNITARIO;
	}

	public LocalDateTime getDATA_ENTREGA_PREVISTA() {
		return DATA_ENTREGA_PREVISTA;
	}

	public void setDATA_ENTREGA_PREVISTA(LocalDateTime dATA_ENTREGA_PREVISTA) {
		DATA_ENTREGA_PREVISTA = dATA_ENTREGA_PREVISTA;
	}

	public LocalDateTime getDATA_COTACAO() {
		return DATA_COTACAO;
	}

	public void setDATA_COTACAO(LocalDateTime dATA_COTACAO) {
		DATA_COTACAO = dATA_COTACAO;
	}	
}