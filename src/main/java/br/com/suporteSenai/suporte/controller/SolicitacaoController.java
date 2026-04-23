package br.com.suporteSenai.suporte.controller;

import br.com.suporteSenai.suporte.model.Solicitacao;
import br.com.suporteSenai.suporte.model.TipoProblema;
import br.com.suporteSenai.suporte.service.SolicitacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SolicitacaoController {
    private final SolicitacaoService solicitacaoService;

    @Autowired
    public SolicitacaoController(SolicitacaoService solicitacaoService){
        this.solicitacaoService = solicitacaoService;
    }

    @GetMapping
    public String exibirFormulario(Model model){
        model.addAttribute("solicitacao", new Solicitacao());
        model.addAttribute("tipos", Solicitacao.TipoProblema.values());
        return "solicitacao/formulario";
    }

    @PostMapping
    public String salvar(
            @Valid @ModelAttribute Solicitacao solicitacao,
            BindingResult resultado,
            Model model,
            RedirectAttributes flash
    ){
        if (resultado.hasErrors()){
            model.addAttribute("Tipos", Solicitacao.TipoProblema.values());
            return "solicitacao/formulario";
        }
        solicitacaoService.salvar(solicitacao);

        flash.addFlashAttribute("sucesso", "Chamado aberto com sucesso! em breve um técnico ira atender");
        return "rendirect:/solicitacao";
    }
}
