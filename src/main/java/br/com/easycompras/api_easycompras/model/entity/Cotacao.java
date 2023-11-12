package br.com.easycompras.api_easycompras.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.easycompras.api_easycompras.model.dto.DadosAtualizacaoCotacao;
import br.com.easycompras.api_easycompras.model.dto.DadosCadastroCotacao;
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

@Entity
@Table(name = "EC_COTACOES")
public class Cotacao 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SQ_EC_COTACOES", sequenceName = "SQ_EC_COTACOES", allocationSize = 1)
	@Column(name = "CODIGO_COTACAO")
	private Long codigoCotacao;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(
				name = "CODIGO_SOLICITACAO",
				referencedColumnName = "CODIGO_SOLICITACAO",
				foreignKey = @ForeignKey(name = "FK_COTACOES_SOLICITACOES")
			)
	private Solicitacao solicitacao;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(
				name = "CODIGO_FORNECEDOR",
				referencedColumnName = "CODIGO_FORNECEDOR",
				foreignKey = @ForeignKey(name = "FK_COTACOES_FORNECEDORES")
			)
	private Fornecedor fornecedor;
	
	@Column(name = "VALOR_UNITARIO", nullable = false)
	private BigDecimal valorUnitario;
	
	@Column(name = "DATA_ENTREGA_PREVISTA")
	private LocalDateTime dataEntregaPrevista;
	
	@Column(name = "DATA_COTACAO", nullable = false)
	private LocalDateTime dataCotacao;
	
	@Column(name = "COTACAO_APROVADA")
	private Boolean cotacaoAprovada;
	
	// CONSTRUTOR
	public Cotacao() {
		super();
	}

	public Cotacao(DadosCadastroCotacao dados) {
		this.solicitacao = new Solicitacao(dados.solicitacao());
		this.fornecedor = new Fornecedor(dados.fornecedor());
		this.valorUnitario = dados.valorUnitario();
		this.dataEntregaPrevista = dados.dataEntregaPrevista();
		this.dataCotacao = dados.dataCotacao();
		this.cotacaoAprovada = dados.cotacaoAprovada();
	}
	
	public void atualizar(DadosAtualizacaoCotacao dados) {
		if (dados.solicitacao() != null) {
			this.solicitacao.atualizarSemPK(dados.solicitacao());
		}
		
		if (dados.fornecedor() != null) {
			this.fornecedor.atualizarSemPK(dados.fornecedor());
		}
		
		if (dados.valorUnitario() != null) {
			this.valorUnitario = dados.valorUnitario();
		}
		
		if (dados.dataEntregaPrevista() != null) {
			this.dataEntregaPrevista = dados.dataEntregaPrevista();
		}
		
		if (dados.dataCotacao() != null) {
			this.dataCotacao = dados.dataCotacao();
		}
		
		if (dados.cotacaoAprovada() != null) {
			this.cotacaoAprovada = dados.cotacaoAprovada();
		}
	}
	
	// GETTERS AND SETTERS
	public Long getCodigoCotacao() {
		return codigoCotacao;
	}

	public void setCodigoCotacao(Long codigoCotacao) {
		this.codigoCotacao = codigoCotacao;
	}

	public Solicitacao getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(Solicitacao solicitacao) {
		this.solicitacao = solicitacao;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public LocalDateTime getDataEntregaPrevista() {
		return dataEntregaPrevista;
	}

	public void setDataEntregaPrevista(LocalDateTime dataEntregaPrevista) {
		this.dataEntregaPrevista = dataEntregaPrevista;
	}

	public LocalDateTime getDataCotacao() {
		return dataCotacao;
	}

	public void setDataCotacao(LocalDateTime dataCotacao) {
		this.dataCotacao = dataCotacao;
	}

	public Boolean getCotacaoAprovada() {
		return cotacaoAprovada;
	}

	public void setCotacaoAprovada(Boolean cotacaoAprovada) {
		this.cotacaoAprovada = cotacaoAprovada;
	}

	// TO STRING
	@Override
	public String toString() {
		return "Cotacao ["
				+ "codigoCotacao=" + codigoCotacao 
				+ ", codigoSolicitacao=" + solicitacao
				+ ", codigoFornecedor=" + fornecedor 
				+ ", valorUnitario=" + valorUnitario
				+ ", dataEntregaPrevista=" + dataEntregaPrevista 
				+ ", dataCotacao=" + dataCotacao 
				+ ", cotacaoAprovada=" + cotacaoAprovada 
				+ "]";
	}
}