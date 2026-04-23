package br.com.suporteSenai.suporte.service;

import br.com.suporteSenai.suporte.model.PainelTecnico;
import br.com.suporteSenai.suporte.model.Solicitacao;
import br.com.suporteSenai.suporte.repository.PainelTecnicoRepository;
import br.com.suporteSenai.suporte.repository.SolicitacaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PainelTecnicoService {

    private final PainelTecnicoRepository painelTecnicoRepository;
    private final SolicitacaoRepository solicitacaoRepository;

    @Autowired
    public PainelTecnicoService(PainelTecnicoRepository painel, SolicitacaoRepository solicitacaoRepository) {
        this.painelTecnicoRepository = painelTecnicoRepository;
        this.solicitacaoRepository = solicitacaoRepository;
    }

    @Transactional
    public PainelTecnico assumir(Long solicitacaoId, String tecnicoResponsavel, String observacoes) {
        Solicitacao solicitacao = solicitacaoRepository.findById(solicitacaoId).orElseThrow(() -> new RuntimeException("Solicitação não encontrada ID" + solicitacaoId));

        if (solicitacao.getStatus() != Solicitacao.StatusSolicitacao.PENDENTE) {
            throw new IlegalStateException(
                    "Esta solicitacao não pode ser assumida. Status atual: "
                            + solicitacao.getStatus().getDescricao()
            );
        }
    }
    public PainelTecnico assumir1 (Long solicitacaoId, String tecnicoResponsavel){
        PainelTecnico painel = new PainelTecnico();
        painel.setSolicitacao(solicitacao);
        painel.setTecnicoResponsavel(tecnicoResponsavel);
        painel.setObservacoes(observacoes);

        solicitacao.setStatus(Solicitacao.StatusSolicitacao.EM_ANDAMENTO);
        solicitacaoRepository.save(solicitacao);
        return painelTecnicoRepository.save(painel);
    }

    @Transactional
    public void concluir(Long solicitacaoId){
        Solicitacao solicitacao = solicitacaoRepository
    }
}
