package br.com.easycompras.api_easycompras.model.dto;

import br.com.easycompras.api_easycompras.model.entity.Endereco;

public record DadosListagemEndereco(Long codigoEndereco, String numero, String complemento, String cep) 
{
	public DadosListagemEndereco(Endereco endereco) 
	{
		this(endereco.getCodigoEndereco(), endereco.getNumero(), endereco.getComplemento(), endereco.getCep());
	}
}
