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

import br.com.easycompras.api_easycompras.model.ProdutoRepository;
import br.com.easycompras.api_easycompras.model.dto.DadosAtualizacaoProduto;
import br.com.easycompras.api_easycompras.model.dto.DadosCadastroProduto;
import br.com.easycompras.api_easycompras.model.dto.DadosListagemProduto;
import br.com.easycompras.api_easycompras.model.entity.Produto;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/produto")
public class ProdutoController 
{
	@Autowired
	private ProdutoRepository repository;

	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastroProduto dados) {
		repository.save(new Produto(dados));
	}

	@GetMapping
	public Page<DadosListagemProduto> listar(Pageable paginacao) {
		return repository.findAll(paginacao).map(DadosListagemProduto::new);
	}
	
	@GetMapping("/{id}")
	public DadosListagemProduto obterPorId(@PathVariable String id) {
	    Produto produto = repository.findById(id).orElse(null);

	    if (produto != null) {
	        return new DadosListagemProduto(produto);
	    } else {
	        return null;
	    }
	}
	
	@PutMapping
	@Transactional
	public void atualizar(@RequestBody @Valid DadosAtualizacaoProduto dados) {
		Produto produto = new Produto();
		produto = repository.getReferenceById(dados.sku());
		produto.atualizar(dados);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public void excluir(@PathVariable String id) {
		repository.deleteById(id);
	}
}
