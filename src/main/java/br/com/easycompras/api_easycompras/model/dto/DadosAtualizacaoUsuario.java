package br.com.easycompras.api_easycompras.model.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DadosAtualizacaoUsuario(
		@NotNull
		Long codigoUsuario,

		@Size(max = 255)
		String nome,

		@Size(max = 255)
		String senha,

		@Size(max = 255)
		String email,

		@Valid
		DadosAtualizacaoEnderecoUsuario endereco) {
}
