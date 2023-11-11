package br.com.easycompras.api_easycompras.model.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record DadosAtualizacaoEnderecoUsuario(
		String numero,
		
		@Size(max = 100)
		String complemento,
		
		@Pattern(regexp = "\\d{5}-\\d{3}")
		String cep) {
}
