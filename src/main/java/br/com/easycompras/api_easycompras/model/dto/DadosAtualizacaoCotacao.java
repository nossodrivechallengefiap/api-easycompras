package br.com.easycompras.api_easycompras.model.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCotacao(
		@NotNull
		Long codigoCotacao,
		
		@Valid
		DadosAtualizacaoSolicitacaoSemPK solicitacao,
		
		@Valid
		DadosAtualizacaoFornecedorSemPK fornecedor,
		
		BigDecimal valorUnitario,
		
		LocalDateTime dataEntregaPrevista,
		
		LocalDateTime dataCotacao,
		
		Boolean cotacaoAprovada) {

}
