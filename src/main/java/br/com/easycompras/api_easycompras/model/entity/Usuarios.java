package br.com.easycompras.api_easycompras.model.entity;

public class Usuarios {

	private Long CODIGO_USUARIO;
	private String NOME;
	private String SENHA;
	private String EMAIL;
	private Long CODIGO_ENDERECO;
	
	//CONSTRUTORES
	public Usuarios() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//GETTERS AND SETTERS
	public Long getCODIGO_USUARIO() {
		return CODIGO_USUARIO;
	}
	public void setCODIGO_USUARIO(Long cODIGO_USUARIO) {
		CODIGO_USUARIO = cODIGO_USUARIO;
	}
	public String getNOME() {
		return NOME;
	}
	public void setNOME(String nOME) {
		NOME = nOME;
	}
	public String getSENHA() {
		return SENHA;
	}
	public void setSENHA(String sENHA) {
		SENHA = sENHA;
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
