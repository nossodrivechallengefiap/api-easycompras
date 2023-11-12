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

import br.com.easycompras.api_easycompras.model.CotacaoRepository;
import br.com.easycompras.api_easycompras.model.dto.DadosAtualizacaoCotacao;
import br.com.easycompras.api_easycompras.model.dto.DadosCadastroCotacao;
import br.com.easycompras.api_easycompras.model.dto.DadosListagemCotacao;
import br.com.easycompras.api_easycompras.model.entity.Cotacao;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cotacao")
public class CotacaoController {
	@Autowired
	private CotacaoRepository repository;

	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastroCotacao dados) {
		repository.save(new Cotacao(dados));
	}

	@GetMapping
	public Page<DadosListagemCotacao> listar(
			@PageableDefault(size = 3, sort = {"solicitacao.produto.nomeProduto"}) Pageable paginacao){
		return repository.findAll(paginacao).map(DadosListagemCotacao :: new);
	}
	
	@PutMapping
	@Transactional
	public void atualizar(@RequestBody @Valid DadosAtualizacaoCotacao dados) {
		Cotacao cotacao = new Cotacao();
		cotacao = repository.getReferenceById(dados.codigoCotacao());
		cotacao.atualizar(dados);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public void excluir(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
