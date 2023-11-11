package br.com.easycompras.api_easycompras.model;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.easycompras.api_easycompras.model.entity.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long>{

}
