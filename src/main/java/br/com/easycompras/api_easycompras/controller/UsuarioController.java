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

import br.com.easycompras.api_easycompras.model.UsuarioRepository;
import br.com.easycompras.api_easycompras.model.dto.DadosAtualizacaoUsuario;
import br.com.easycompras.api_easycompras.model.dto.DadosCadastroUsuario;
import br.com.easycompras.api_easycompras.model.dto.DadosListagemUsuario;
import br.com.easycompras.api_easycompras.model.entity.Usuario;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UsuarioController 
{
	@Autowired
	private UsuarioRepository repository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastroUsuario dados) {
		repository.save(new Usuario(dados));
	}
	
	@GetMapping
	public Page<DadosListagemUsuario> listar(
			@PageableDefault(size = 3, sort = {"nome"}) Pageable paginacao){
		return repository.findAll(paginacao).map(DadosListagemUsuario :: new);
	}
	
	@GetMapping("/{id}")
	public DadosListagemUsuario obterPorId(@PathVariable Long id) {
	    Usuario usuario = repository.findById(id).orElse(null);

	    if (usuario != null) {
	        return new DadosListagemUsuario(usuario);
	    } else {
	        return null;
	    }
	}
	
	@PutMapping
	@Transactional
	public void atualizar(@RequestBody @Valid DadosAtualizacaoUsuario dados) {
		Usuario usuario = new Usuario();
		usuario = repository.getReferenceById(dados.codigoUsuario());
		usuario.atualizar(dados);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public void excluir(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
