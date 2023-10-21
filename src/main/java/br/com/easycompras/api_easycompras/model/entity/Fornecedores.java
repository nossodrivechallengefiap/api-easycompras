package br.com.easycompras.api_easycompras.model.entity;

public class Fornecedores {

	private Long CODIGO_FORNECEDOR;
	private String RAZAO_SOCIAL;
	private String CNPJ;
	private String NOME_CONTATO;
	private String TELEFONE;
	private String EMAIL;
	private Long CODIGO_ENDERECO;
	
	//CONSTRUTOR
	public Fornecedores() {
		super();
	}
	
	//GETTERS AND SETTERS
	public Long getCODIGO_FORNECEDOR() {
		return CODIGO_FORNECEDOR;
	}
	
	public void setCODIGO_FORNECEDOR(Long cODIGO_FORNECEDOR) {
		CODIGO_FORNECEDOR = cODIGO_FORNECEDOR;
	}
	public String getRAZAO_SOCIAL() {
		return RAZAO_SOCIAL;
	}
	public void setRAZAO_SOCIAL(String rAZAO_SOCIAL) {
		RAZAO_SOCIAL = rAZAO_SOCIAL;
	}
	public String getCNPJ() {
		return CNPJ;
	}
	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}
	public String getNOME_CONTATO() {
		return NOME_CONTATO;
	}
	public void setNOME_CONTATO(String nOME_CONTATO) {
		NOME_CONTATO = nOME_CONTATO;
	}
	public String getTELEFONE() {
		return TELEFONE;
	}
	public void setTELEFONE(String tELEFONE) {
		TELEFONE = tELEFONE;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	public Long getCODIGO_ENDERECO() {
		return CODIGO_ENDERECO;
	}
	public void setCODIGO_ENDERECO(Long cODIGO_ENDERECO) {
		CODIGO_ENDERECO = cODIGO_ENDERECO;
	}
	
		
}
