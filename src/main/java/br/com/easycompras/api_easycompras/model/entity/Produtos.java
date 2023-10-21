package br.com.easycompras.api_easycompras.model.entity;

public class Produtos {
	
	private String SKU;
	private String NOME_PRODUTO;
	
	//CONSTRUTORES
	public Produtos() {
		super();
	}
	
	//GETTERS AND SETTERS
	public String getSKU() {
		return SKU;
	}
	public void setSKU(String sKU) {
		SKU = sKU;
	}
	public String getNOME_PRODUTO() {
		return NOME_PRODUTO;
	}
	public void setNOME_PRODUTO(String nOME_PRODUTO) {
		NOME_PRODUTO = nOME_PRODUTO;
	}
	
}
