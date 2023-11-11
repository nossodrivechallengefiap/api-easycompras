package br.com.easycompras.api_easycompras.model.dto;

import br.com.easycompras.api_easycompras.model.entity.Produto;

public record DadosListagemProduto(String sku, String nomeProduto, String descricao) {
	
	public DadosListagemProduto(Produto produto) {
		this (produto.getSku(), produto.getNomeProduto(), produto.getDescricao());
	}

}
