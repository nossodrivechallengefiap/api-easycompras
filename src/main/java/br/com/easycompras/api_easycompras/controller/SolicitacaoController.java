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

import br.com.easycompras.api_easycompras.model.SolicitacaoRepository;
import br.com.easycompras.api_easycompras.model.dto.DadosAtualizacaoSolicitacao;
import br.com.easycompras.api_easycompras.model.dto.DadosCadastroSolicitacao;
import br.com.easycompras.api_easycompras.model.dto.DadosListagemSolicitacao;
import br.com.easycompras.api_easycompras.model.entity.Solicitacao;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/solicitacao")
public class SolicitacaoController 
{
	@Autowired
	private SolicitacaoRepository repository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastroSolicitacao dados) {		
		repository.save(new Solicitacao(dados));
	}

	@GetMapping
	public Page<DadosListagemSolicitacao> listar(
			@PageableDefault(size = 3, sort = {"produto.nomeProduto"}) Pageable paginacao){
		return repository.findAll(paginacao).map(DadosListagemSolicitacao :: new);
	}
	
	@GetMapping("/{id}")
	public DadosListagemSolicitacao obterPorId(@PathVariable Long id) {
	    Solicitacao solicitacao = repository.findById(id).orElse(null);

	    if (solicitacao != null) {
	        return new DadosListagemSolicitacao(solicitacao);
	    } else {
	        return null;
	    }
	}

	@PutMapping
	@Transactional
	public void atualizar(@RequestBody @Valid DadosAtualizacaoSolicitacao dados) {
		Solicitacao solicitacao = new Solicitacao();
		solicitacao = repository.getReferenceById(dados.codigoSolicitacao());
		solicitacao.atualizar(dados);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public void excluir(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
