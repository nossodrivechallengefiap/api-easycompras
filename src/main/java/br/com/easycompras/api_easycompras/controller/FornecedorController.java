package br.com.easycompras.api_easycompras.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.easycompras.api_easycompras.model.FornecedorRepository;
import br.com.easycompras.api_easycompras.model.dto.DadosAtualizacaoFornecedor;
import br.com.easycompras.api_easycompras.model.dto.DadosCadastroFornecedor;
import br.com.easycompras.api_easycompras.model.dto.DadosListagemFornecedor;
import br.com.easycompras.api_easycompras.model.entity.Fornecedor;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController 
{
	@Autowired
	private FornecedorRepository repository;

	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastroFornecedor dados) {
		repository.save(new Fornecedor(dados));
	}

	@GetMapping
	public Page<DadosListagemFornecedor> listar(
			@PageableDefault(size = 3, sort = {"razaoSocial"}) Pageable paginacao){
		return repository.findAll(paginacao).map(DadosListagemFornecedor :: new);
	}
	
	@GetMapping("/{id}")
	public DadosListagemFornecedor obterPorId(@PathVariable Long id) {
	    Fornecedor fornecedor = repository.findById(id).orElse(null);

	    if (fornecedor != null) {
	        return new DadosListagemFornecedor(fornecedor);
	    } else {
	        return null;
	    }
	}
	
	@PutMapping
	@Transactional
	public void atualizar(@RequestBody @Valid DadosAtualizacaoFornecedor dados) {
		Fornecedor fornecedor = new Fornecedor();
		fornecedor = repository.getReferenceById(dados.codigoFornecedor());
		fornecedor.atualizar(dados);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public void excluir(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
