package br.com.easycompras.api_easycompras.model.entity;

import java.time.LocalDateTime;

import br.com.easycompras.api_easycompras.model.dto.DadosAtualizacaoSolicitacao;
import br.com.easycompras.api_easycompras.model.dto.DadosAtualizacaoSolicitacaoSemPK;
import br.com.easycompras.api_easycompras.model.dto.DadosCadastroSolicitacao;
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
@Table(name = "EC_SOLICITACOES")
public class Solicitacao 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SQ_EC_SOLICITACOES", sequenceName = "SQ_EC_SOLICITACOES", allocationSize = 1)
	@Column(name = "CODIGO_SOLICITACAO")
	private Long codigoSolicitacao;
		
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(
				name = "SKU",
				referencedColumnName = "SKU",
				foreignKey = @ForeignKey(name = "FK_SOLICITACOES_PRODUTOS")
			)
	private Produto produto;
	
	@Column(name = "QUANTIDADE", nullable = false)
	private Long quantidade;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(
				name = "CODIGO_USUARIO",
				referencedColumnName = "CODIGO_USUARIO",
				foreignKey = @ForeignKey(name = "FK_SOLICITACOES_USUARIOS")
			)
	private Usuario usuario;
	
	@Column(name = "DATA_SOLICITACAO", nullable = false)
	private LocalDateTime dataSolicitacao;
	
	// CONSTRUTORES
	public Solicitacao() {
		super();
	}
	
	public Solicitacao(DadosCadastroSolicitacao dados) {
		this.produto = new Produto(dados.produto());
		this.quantidade = dados.quantidade();
		this.usuario = new Usuario(dados.usuario());
		this.dataSolicitacao = dados.dataSolicitacao();
	}
	
	public void atualizar(DadosAtualizacaoSolicitacao dados) {
		if (dados.produto() != null) {
			this.produto.atualizar(dados.produto());
		}
		
		if (dados.quantidade() != null) {
			this.quantidade = dados.quantidade();
		}
		
		if (dados.usuario() != null) {
			this.usuario.atualizarSemPK(dados.usuario());
		}
		
		if (dados.dataSolicitacao() != null) {
			this.dataSolicitacao = dados.dataSolicitacao();
		}
	}
	
	public void atualizarSemPK(DadosAtualizacaoSolicitacaoSemPK dados) {
		if (dados.produto() != null) {
			this.produto.atualizar(dados.produto());
		}
		
		if (dados.quantidade() != null) {
			this.quantidade = dados.quantidade();
		}
		
		if (dados.usuario() != null) {
			this.usuario.atualizarSemPK(dados.usuario());
		}
		
		if (dados.dataSolicitacao() != null) {
			this.dataSolicitacao = dados.dataSolicitacao();
		}
	}

	//GETTERS AND SETTERS
	public Long getCodigoSolicitacao() {
		return codigoSolicitacao;
	}

	public void setCodigoSolicitacao(Long codigoSolicitacao) {
		this.codigoSolicitacao = codigoSolicitacao;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public LocalDateTime getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(LocalDateTime dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	// TO STRING
	@Override
	public String toString() 
	{
		return "Solicitacao ["
				+ "codigoSolicitacao=" + codigoSolicitacao 
				+ ", produto=" + produto 
				+ ", quantidade=" + quantidade 
				+ ", usuario=" + usuario 
				+ ", dataSolicitacao=" + dataSolicitacao 
				+ "]";
	}
}
