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

import br.com.easycompras.api_easycompras.model.EnderecoRepository;
import br.com.easycompras.api_easycompras.model.dto.DadosAtualizacaoEndereco;
import br.com.easycompras.api_easycompras.model.dto.DadosCadastroEndereco;
import br.com.easycompras.api_easycompras.model.dto.DadosListagemEndereco;
import br.com.easycompras.api_easycompras.model.entity.Endereco;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/endereco")
public class EnderecoController 
{
	@Autowired
	private EnderecoRepository repository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastroEndereco dados) {
		repository.save(new Endereco(dados));	
	}

	@GetMapping
	public Page<DadosListagemEndereco> listar(Pageable paginacao){
		return repository.findAll(paginacao).map(DadosListagemEndereco::new);
	}
	
	@GetMapping("/{id}")
	public DadosListagemEndereco obterPorId(@PathVariable Long id) {
	    Endereco endereco = repository.findById(id).orElse(null);

	    if (endereco != null) {
	        return new DadosListagemEndereco(endereco);
	    } else {
	        return null;
	    }
	}
	
	@PutMapping
	@Transactional
	public void atualizar(@RequestBody @Valid DadosAtualizacaoEndereco dados) {
		Endereco endereco = new Endereco();
		endereco = repository.getReferenceById(dados.codigoEndereco());
		endereco.atualizar(dados);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public void excluir(@PathVariable Long id) {
		repository.deleteById(id);
		
//		Endereco endereco = new Endereco();
//		endereco = repository.getReferenceById(id);
//		endereco.excluir();
	}
}