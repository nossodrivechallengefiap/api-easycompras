package br.com.easycompras.api_easycompras.model.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DadosCadastroUsuario(
		@NotBlank
		@Size(max = 255)
		String nome,
		
		@NotBlank
		@Size(max = 255)
		String senha,
		
		@NotBlank
		@Size(max = 255)
		String email,
		
		@NotNull
		@Valid
		DadosCadastroEndereco endereco) {
}
