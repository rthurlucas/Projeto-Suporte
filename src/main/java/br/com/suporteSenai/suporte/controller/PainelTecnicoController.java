package br.com.suporteSenai.suporte.controller;

import br.com.suporteSenai.suporte.model.Solicitacao;
import br.com.suporteSenai.suporte.model.TipoProblema;
import br.com.suporteSenai.suporte.service.PainelTecnicoService;
import br.com.suporteSenai.suporte.service.SolicitacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/painel")
public class PainelTecnicoController {

    private final SolicitacaoService solicitacaoService;
    private final PainelTecnicoService painelTecnicoService;

    @Autowired
    public PainelTecnicoController(SolicitacaoService solicitacaoService,
                                   PainelTecnicoService painelTecnicoService){
        this.solicitacaoService = solicitacaoService;
        this.painelTecnicoService = painelTecnicoService;
    }

    @GetMapping
    public String listar(
            @RequestParam(required = false)Solicitacao.TipoProblema tipo,
            @RequestParam(required = false)Solicitacao.StatusSolicitacao status,
            Model model
            ){
        model.addAttribute("solicitacoes", solicitacaoService.filtrar(tipo, status));
        model.addAttribute("tipos", TipoProblema.values());
        model.addAttribute("statusList", Solicitacao.StatusSolicitacao.values());
    }
}
