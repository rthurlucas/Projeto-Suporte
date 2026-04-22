package br.com.suporteSenai.suporte.repository;

import br.com.suporteSenai.suporte.model.PainelTecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PainelTecnicoRepository extends JpaRepository<PainelTecnico, Long> {

    Optional<PainelTecnico> findBySolicitacaoId(Long Solicitacao);
}
