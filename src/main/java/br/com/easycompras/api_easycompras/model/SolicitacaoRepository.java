package br.com.easycompras.api_easycompras.model;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.easycompras.api_easycompras.model.entity.Solicitacao;

public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Long>{

}
