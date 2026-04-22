package br.com.suporteSenai.suporte.service;

import br.com.suporteSenai.suporte.model.Solicitacao;
import br.com.suporteSenai.suporte.repository.SolicitacaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolicitacaoService {

    private final SolicitacaoRepository solicitacaoRepository;

   @Autowired
   public SolicitacaoRepository (SolicitacaoRepository solicitacaoRepository){
       this.solicitacaoRepository = solicitacaoRepository;
   }

    @Transactional
    public Solicitacao salvar(Solicitacao solicitacao){
        return Solicitacao.save(solicitacao);
    }

    @Transactional(readOnly = true)
    public List<Solicitacao> listarTodas(){
       return solicitacaoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Solicitacao buscarPorId(Long id){
       return solicitacaoRepository.findById(id).orElseThrow(()-> new RuntimeException(("Solicitação nao encontrada. ID: " + id)));
    }

    @Transactional(readOnly = true){
       public List<Solicitacao> filtrar(Solicitacao.TipoProblema tipo, Solicitacao.StatusSolicitacao status){
           if (tipo != null && status != null){
               reutnr solicitacaoRepository.findByStatusAndTipoProblema(status, tipo);
           }
           if (tipo != null){
               return solicitacaoRepository.findByTipoProblema(tipo);
           }
           if (status != null){
               return solicitacaoRepository.findByStatus(status);
           }
           return solicitacaoRepository.findAll();
        }

        @Transactional
       public Solicitacao atualizar(Long id, Solicitacao dadosNovos){
           Solicitacao existente = buscarPorId(id);

           existente.setNif(dadosNovos.getNif());
           existente.setNomeSolicitante(dadosNovos.getNomeSolicitante);
           existente.setNumeroSala(dadosNovos.getNumeroSala);
            existente.setCodigoPatrimonio(dadosNovos.getCodigoPatrimonio());
            existente.setDescricaoProblema(dadosNovos.getDescricaoProblema());
            existente.setTipoProblema(dadosNovos.getTipoProblema());
            existente.setStatus(dadosNovos.getStatus());

            return solicitacaoRepository.save(existente);
        }
    }
}
