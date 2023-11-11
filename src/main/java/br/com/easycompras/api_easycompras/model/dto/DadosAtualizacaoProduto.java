package br.com.easycompras.api_easycompras.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DadosAtualizacaoProduto(
		@NotBlank
		String sku,
		
		@Size(max = 255)
		String nomeProduto,
		
		@Size(max = 1000)
		String descricao) {

}
