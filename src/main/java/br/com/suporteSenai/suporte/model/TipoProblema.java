package br.com.suporteSenai.suporte.model;

public enum TipoProblema {
    INFORMATICA("Informática"),
    ELETRICA("Eletrica"),
    ZELADORIA("Zeladoria");

    private final String descricao;

    TipoProblema(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }
}
