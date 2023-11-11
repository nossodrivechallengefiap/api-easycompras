package br.com.easycompras.api_easycompras.model;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.easycompras.api_easycompras.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
