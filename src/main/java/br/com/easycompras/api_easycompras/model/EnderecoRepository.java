package br.com.easycompras.api_easycompras.model;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.easycompras.api_easycompras.model.entity.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{
	
//	Page<Endereco> findAllByAtivoTrue(Pageable paginacao);
	
}
