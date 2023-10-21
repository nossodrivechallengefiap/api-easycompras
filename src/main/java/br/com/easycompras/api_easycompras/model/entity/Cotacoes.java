package br.com.easycompras.api_easycompras.model.entity;

import java.time.LocalDateTime;

public class Cotacoes {

	private Long CODIGO_COTACAO;
	private Long CODIGO_SOLICITACAO;
	private Long CODIGO_FORNECEDOR;
	private Long VALOR_UNITARIO;
	private LocalDateTime DATA_ENTREGA_PREVISTA;
	private LocalDateTime DATA_COTACAO;
	
	//CONSTRUTOR
	public Cotacoes() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//GETTERS AND SETTERS
	
	public Long getCODIGO_COTACAO() {
		return CODIGO_COTACAO;
	}
	public void setCODIGO_COTACAO(Long cODIGO_COTACAO) {
		CODIGO_COTACAO = cODIGO_COTACAO;
	}
	public Long getCODIGO_SOLICITACAO() {
		return CODIGO_SOLICITACAO;
	}
	public void setCODIGO_SOLICITACAO(Long cODIGO_SOLICITACAO) {
		CODIGO_SOLICITACAO = cODIGO_SOLICITACAO;
	}
	public Long getCODIGO_FORNECEDOR() {
		return CODIGO_FORNECEDOR;
	}
	public void setCODIGO_FORNECEDOR(Long cODIGO_FORNECEDOR) {
		CODIGO_FORNECEDOR = cODIGO_FORNECEDOR;
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