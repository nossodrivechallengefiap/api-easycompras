package br.com.easycompras.api_easycompras.model.entity;

public class Enderecos {
	
	private Long CODIGO_ENDERECO;
	private String LOGRADOURO;
	private String NUMERO;
	private String COMPLEMENTO;
	private String BAIRRO;
	private String CIDADE;
	private String ESTADO;
	private String CEP;

	//CONSTRUTOR
	public Enderecos() {
		super();
		// TODO Auto-generated constructor stub
	}

	//GETTERS AND SETTERS
	public Long getCODIGO_ENDERECO() {
		return CODIGO_ENDERECO;
	}

	public void setCODIGO_ENDERECO(Long cODIGO_ENDERECO) {
		CODIGO_ENDERECO = cODIGO_ENDERECO;
	}

	public String getLOGRADOURO() {
		return LOGRADOURO;
	}

	public void setLOGRADOURO(String lOGRADOURO) {
		LOGRADOURO = lOGRADOURO;
	}

	public String getNUMERO() {
		return NUMERO;
	}

	public void setNUMERO(String nUMERO) {
		NUMERO = nUMERO;
	}

	public String getCOMPLEMENTO() {
		return COMPLEMENTO;
	}

	public void setCOMPLEMENTO(String cOMPLEMENTO) {
		COMPLEMENTO = cOMPLEMENTO;
	}

	public String getBAIRRO() {
		return BAIRRO;
	}

	public void setBAIRRO(String bAIRRO) {
		BAIRRO = bAIRRO;
	}

	public String getCIDADE() {
		return CIDADE;
	}

	public void setCIDADE(String cIDADE) {
		CIDADE = cIDADE;
	}

	public String getESTADO() {
		return ESTADO;
	}

	public void setESTADO(String eSTADO) {
		ESTADO = eSTADO;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String cEP) {
		CEP = cEP;
	}
	
}
