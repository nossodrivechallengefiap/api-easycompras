package br.com.easycompras.api_easycompras.model.dto;

import java.time.LocalDateTime;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroSolicitacao(
		@NotNull
		@Valid
		DadosCadastroProduto produto, 
		
		@NotNull
		Long quantidade,
		
		@NotNull
		@Valid
		DadosCadastroUsuario usuario,
		
		@NotNull
		LocalDateTime dataSolicitacao) {
}
