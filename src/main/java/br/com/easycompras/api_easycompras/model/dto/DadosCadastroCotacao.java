package br.com.easycompras.api_easycompras.model.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroCotacao(
		@NotNull
		@Valid
		DadosCadastroSolicitacao solicitacao,
		
		@NotNull
		@Valid
		DadosCadastroFornecedor fornecedor,
		
		@NotNull
		BigDecimal valorUnitario,
		
		LocalDateTime dataEntregaPrevista,
		
		@NotNull
		LocalDateTime dataCotacao,
		
		Boolean cotacaoAprovada) {

}
