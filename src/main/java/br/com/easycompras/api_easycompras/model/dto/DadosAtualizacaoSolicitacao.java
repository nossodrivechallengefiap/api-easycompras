package br.com.easycompras.api_easycompras.model.dto;

import java.time.LocalDateTime;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoSolicitacao(
		@NotNull
		Long codigoSolicitacao,
		
		@Valid
		DadosAtualizacaoProduto produto, 
		
		Long quantidade,
		
		@Valid
		DadosAtualizacaoUsuarioSemPK usuario,
		
		LocalDateTime dataSolicitacao) {

}
