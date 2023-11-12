package br.com.easycompras.api_easycompras.model.dto;

import java.time.LocalDateTime;

import br.com.easycompras.api_easycompras.model.entity.Solicitacao;

public record DadosListagemSolicitacao(
		Long codigoSolicitacao,
		String sku, 
		String nomeProduto, 
		String descricao, 
		Long quantidade, 
		String nome,
		String email, 
		LocalDateTime dataSolicitacao
		) 
{
	public DadosListagemSolicitacao(Solicitacao solicitacao) 
	{
		this(
				solicitacao.getCodigoSolicitacao(),
				solicitacao.getProduto().getSku(),
				solicitacao.getProduto().getNomeProduto(),
				solicitacao.getProduto().getDescricao(),
				solicitacao.getQuantidade(),
				solicitacao.getUsuario().getNome(),
				solicitacao.getUsuario().getEmail(),
				solicitacao.getDataSolicitacao()
			);
	}
}
