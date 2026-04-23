package br.com.suporteSenai.suporte.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "solicitacao")
public class Solicitacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "NIF é obrigatorio")
    @Column(nullable = false, length = 20)
    private String nif;

    @NotBlank
    @Size(min = 3, max = 100, message = "Nome deve ter entre 3 e 100 caracteres")
    @Column(nullable = false)
    private String nomeSolicitante;

    @NotBlank(message = "Número da sala é obrigatorio")
    @Column(nullable = false, length = 10)
    private String numeroSala;

    @NotBlank(message = "Codigo de patrimô é obrigatório")
    @Column(nullable = false, length = 30)
    private String codigoPatrimonio;

    @NotBlank(message = "Descricao do problema é obrigatorio")
    @Column(nullable = false, columnDefinition = "TEXT")
    private String descricaoProblema;

    //@Enumerated(EnumType.STRING) -> salva "INFORMATICA" no banco, nao 0
    @NotNull(message = "Tipo de problema é obrigatorio")
    @Enumerated(EnumType.STRING)
    @Column (nullable = false, length = 20)
    private TipoProblema tipoProblema;

    //Status comeca sempre como PENDENTE
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private StatusSolicitacao status = StatusSolicitacao.PENDENTE;

    //CONTRUCTOR
    public Solicitacao(){

    }


    //GETTER E SETTER
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNif() {
        return nif;
    }
    public void setNif(String nif) {
        this.nif = nif;
    }
    public String getNomeSolicitante() {
        return nomeSolicitante;
    }
    public void setNomeSolicitante(String nomeSolicitante) {
        this.nomeSolicitante = nomeSolicitante;
    }
    public String getNumeroSala() {
        return numeroSala;
    }
    public void setNumeroSala(String numeroSala) {
        this.numeroSala = numeroSala;
    }
    public String getCodigoPatrimonio() {
        return codigoPatrimonio;
    }
    public void setCodigoPatrimonio(String codigoPatrimonio) {
        this.codigoPatrimonio = codigoPatrimonio;
    }
    public String getDescricaoProblema() {
        return descricaoProblema;
    }
    public void setDescricaoProblema(String descricaoProblema) {
        this.descricaoProblema = descricaoProblema;
    }
    public TipoProblema getTipoProblema() {
        return tipoProblema;
    }
    public void setTipoProblema(TipoProblema tipoProblema) {
        this.tipoProblema = tipoProblema;
    }
    public StatusSolicitacao getStatus() {
        return status;
    }
    public void setStatus(StatusSolicitacao status) {
        this.status = status;
    }
    public enum TipoProblema {
        INFORMATICA("Informática"),
        ELETRICA("Elétrica"),
        ZELADORA("Zeladoria");

        private final String descricao;
        TipoProblema(String descricao) {
            this.descricao = descricao;
        }
        public String getDescricao() {
            return descricao;
        }
    }
    public enum StatusSolicitacao {
        PENDENTE("Pendente"),
        EM_ANDAMENTO("Em andamento"),
        CONCLUIDO("Concluído");

        private final String descricao;

        StatusSolicitacao(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }
    }
}
