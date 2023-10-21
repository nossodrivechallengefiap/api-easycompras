package br.com.easycompras.api_easycompras.model.entity;

import java.time.LocalDateTime;

public class Solicitacoes {

	private Long CODIGO_SOLICITACAO;
	private Long CODIGO_COTACAO_APROVADO;
	private String SKU;
	private Long QUANTIDADE;
	private Long SOLICITANTE;
	private LocalDateTime DATA_SOLICITACAO;
	
	//CONSTRUTOR
	public Solicitacoes() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//GETTERS AND SETTERS
	public Long getCODIGO_SOLICITACAO() {
		return CODIGO_SOLICITACAO;
	}
	public void setCODIGO_SOLICITACAO(Long cODIGO_SOLICITACAO) {
		CODIGO_SOLICITACAO = cODIGO_SOLICITACAO;
	}
	public Long getCODIGO_COTACAO_APROVADO() {
		return CODIGO_COTACAO_APROVADO;
	}
	public void setCODIGO_COTACAO_APROVADO(Long cODIGO_COTACAO_APROVADO) {
		CODIGO_COTACAO_APROVADO = cODIGO_COTACAO_APROVADO;
	}
	public String getSKU() {
		return SKU;
	}
	public void setSKU(String sKU) {
		SKU = sKU;
	}
	public Long getQUANTIDADE() {
		return QUANTIDADE;
	}
	public void setQUANTIDADE(Long qUANTIDADE) {
		QUANTIDADE = qUANTIDADE;
	}
	public Long getSOLICITANTE() {
		return SOLICITANTE;
	}
	public void setSOLICITANTE(Long sOLICITANTE) {
		SOLICITANTE = sOLICITANTE;
	}
	public LocalDateTime getDATA_SOLICITACAO() {
		return DATA_SOLICITACAO;
	}
	public void setDATA_SOLICITACAO(LocalDateTime dATA_SOLICITACAO) {
		DATA_SOLICITACAO = dATA_SOLICITACAO;
	}
	
}
