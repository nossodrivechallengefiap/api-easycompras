package br.com.easycompras.api_easycompras.model.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record DadosCadastroFornecedor(
		@NotBlank
		@Size(max = 255)
		String razaoSocial,
		
		@NotBlank
		@Pattern(regexp = "\\d{2}.\\d{3}.\\d{3}/\\d{4}-\\d{2}")
//		XX.XXX.XXX/YYYY-ZZ
		String cnpj,
		
		@Size(max = 255)
		String nomeContato,
		
		@Size(max = 20)
		String telefone,
		
		@NotBlank
		@Size(max = 255)
		String email,
		
		@NotNull
		@Valid
		DadosCadastroEndereco endereco) {
}
