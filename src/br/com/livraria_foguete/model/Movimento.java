package br.com.livraria_foguete.model;

import java.time.LocalDate;

public class Movimento {
    TipoMovimento tipo;
    Livro livro;
    Usuario usuario;
    LocalDate data;

    public Movimento(TipoMovimento tipo, Livro livro, Usuario usuario, LocalDate data) {
        this.tipo = tipo;
        this.livro = livro;
        this.usuario = usuario;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Movimento{" +
                "tipo=" + tipo.toString() +
                ", livro=" + livro +
                ", usuario=" + usuario.getNome() +
                ", data='" + data + '\'' +
                '}';
    }



}
