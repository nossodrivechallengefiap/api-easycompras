package br.com.easycompras.api_easycompras.controller;

import br.com.easycompras.api_easycompras.model.EnderecoRepository;
import br.com.easycompras.api_easycompras.model.dto.DadosCadastroUsuarioComFK;
import br.com.easycompras.api_easycompras.model.entity.Endereco;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
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
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @PostMapping
    @Transactional
    public HttpEntity<String> cadastrar(@RequestBody @Valid DadosCadastroUsuarioComFK dados) {
        try {
            Endereco enderecoExistente = enderecoRepository.findById(dados.codigoEndereco())
                    .orElseThrow(() -> new EntityNotFoundException("Endereço não encontrado. codigo_endereco: " + dados.codigoEndereco()));

            Usuario novoUsuario = new Usuario(dados);
            novoUsuario.setEndereco(enderecoExistente);

            usuarioRepository.save(novoUsuario);

            return ResponseEntity.ok("ParentEntity created with existing ChildEntity.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error creating Usuario: " + e.getMessage());
        }
    }

    @GetMapping
    public Page<DadosListagemUsuario> listar(
            @PageableDefault(size = 3, sort = {"nome"}) Pageable paginacao) {
        return usuarioRepository.findAll(paginacao).map(DadosListagemUsuario::new);
    }

    @GetMapping("/{id}")
    public DadosListagemUsuario obterPorId(@PathVariable Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);

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
        usuario = usuarioRepository.getReferenceById(dados.codigoUsuario());
        usuario.atualizar(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        usuarioRepository.deleteById(id);
    }
}
