package br.com.easycompras.api_easycompras.model;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.easycompras.api_easycompras.model.entity.Cotacao;

public interface CotacaoRepository extends JpaRepository<Cotacao, Long>{

}
