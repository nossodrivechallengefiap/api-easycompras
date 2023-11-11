package br.com.easycompras.api_easycompras.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record DadosCadastroEndereco(
		@NotBlank(message = "Número não pode ser vazio")
		String numero,
		
		@Size(max = 100)
		String complemento,
		
		@NotBlank
		@Pattern(regexp = "\\d{5}-\\d{3}")
		String cep) {
}
