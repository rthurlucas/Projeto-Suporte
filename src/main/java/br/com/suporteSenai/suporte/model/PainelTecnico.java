package br.com.suporteSenai.suporte.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "painel_tecnico")
public class PainelTecnico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "soliciatao_id", nullable = false, unique = true)
    private Solicitacao solicitacao;

    @NotBlank(message = "Nome do técnico é obrigatório")
    @Column(nullable = false)
    private String tecnicoResponsavel;

    @Column(columnDefinition = "TEXT")
    private String observacoes;

    //Constructor
    public PainelTecnico() {
    }

    public Solicitacao getSolicitacao() {
        return solicitacao;
    }

    public void setSolicitacao(Solicitacao solicitacao) {
        this.solicitacao = solicitacao;
    }

    public String getTecnicoResponsavel() {
        return tecnicoResponsavel;
    }

    public void setTecnicoResponsavel(String tecnicoResponsavel) {
        this.tecnicoResponsavel = tecnicoResponsavel;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}
