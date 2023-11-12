package br.com.easycompras.api_easycompras.model.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.easycompras.api_easycompras.model.entity.Cotacao;

public record DadosListagemCotacao(
		Long codigoCotacao,
//		String codigoSolicitacao,
		String sku,
		String nomeProduto,
		String descricao,
		Long quantidade,
		String nome,
		String emailUsuario,
		String razaoSocial,
		String cnpj,
		String nomeContato,
		String emailFornecedor,
		BigDecimal valorUnitario,
		LocalDateTime dataEntregaPrevista,
		LocalDateTime dataCotacao,
		Boolean cotacaoAprovada
		) {
	public DadosListagemCotacao(Cotacao cotacao) {
		this (
				cotacao.getCodigoCotacao(),
				cotacao.getSolicitacao().getProduto().getSku(),
				cotacao.getSolicitacao().getProduto().getNomeProduto(),
				cotacao.getSolicitacao().getProduto().getDescricao(),
				cotacao.getSolicitacao().getQuantidade(),
				cotacao.getSolicitacao().getUsuario().getNome(),
				cotacao.getSolicitacao().getUsuario().getEmail(),
				cotacao.getFornecedor().getRazaoSocial(),
				cotacao.getFornecedor().getCnpj(),
				cotacao.getFornecedor().getNomeContato(),
				cotacao.getFornecedor().getEmail(),
				cotacao.getValorUnitario(),
				cotacao.getDataEntregaPrevista(),
				cotacao.getDataCotacao(),
				cotacao.getCotacaoAprovada()
				);
		
	}

}
