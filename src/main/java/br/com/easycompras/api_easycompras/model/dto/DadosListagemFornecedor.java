package br.com.easycompras.api_easycompras.model.dto;

import br.com.easycompras.api_easycompras.model.entity.Fornecedor;

public record DadosListagemFornecedor(Long codigoFornecedor, String razaoSocial, String cnpj, String nomeContato,
		String telefone, String email, String numero, String complemento, String cep) {
	
	public DadosListagemFornecedor(Fornecedor fornecedor) {
		this(
				fornecedor.getCodigoFornecedor(),
				fornecedor.getRazaoSocial(),
				fornecedor.getCnpj(),
				fornecedor.getNomeContato(),
				fornecedor.getTelefone(),
				fornecedor.getEmail(),
				fornecedor.getEndereco().getNumero(),
				fornecedor.getEndereco().getComplemento(),
				fornecedor.getEndereco().getCep());
	}
}
