package br.com.easycompras.api_easycompras.model.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;

public record DadosAtualizacaoUsuarioSemPK(
		@Size(max = 255)
		String nome,

		@Size(max = 255)
		String senha,

		@Size(max = 255)
		String email,

		@Valid
		DadosAtualizacaoEnderecoSemPK endereco) {

}
