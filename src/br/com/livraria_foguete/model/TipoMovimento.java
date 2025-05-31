package br.com.livraria_foguete.model;

public enum TipoMovimento {
    EMPRESTIMO ("Empréstimo"),
    DEVOLUCAO ("Devolução");

    private String descricao;

    private TipoMovimento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
