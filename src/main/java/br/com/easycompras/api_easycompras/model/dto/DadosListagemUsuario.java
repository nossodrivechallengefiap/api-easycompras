package br.com.easycompras.api_easycompras.model.dto;

import br.com.easycompras.api_easycompras.model.entity.Usuario;

public record DadosListagemUsuario(Long codigoUsuario, String nome, String senha, String email, String numero, String complemento, String cep) {

	public DadosListagemUsuario(Usuario usuario) {
		this(
				usuario.getCodigoUsuario(), 
				usuario.getNome(), 
				usuario.getSenha(), 
				usuario.getSenha(),
				usuario.getEndereco().getNumero(),
				usuario.getEndereco().getComplemento(),
				usuario.getEndereco().getCep());
	}
}
