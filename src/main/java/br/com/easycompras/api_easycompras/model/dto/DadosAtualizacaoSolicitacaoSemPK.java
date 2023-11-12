package br.com.easycompras.api_easycompras.model.dto;

import java.time.LocalDateTime;

import jakarta.validation.Valid;

public record DadosAtualizacaoSolicitacaoSemPK(
		@Valid
		DadosAtualizacaoProduto produto, 
		
		Long quantidade,
		
		@Valid
		DadosAtualizacaoUsuarioSemPK usuario,
		
		LocalDateTime dataSolicitacao) {

}
