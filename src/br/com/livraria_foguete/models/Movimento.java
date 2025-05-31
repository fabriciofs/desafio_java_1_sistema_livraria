package br.com.livraria_foguete.models;

import java.time.LocalDate;

public class Movimento {
    TipoMovimento tipo;
    Livro livro;
    Usuario usuario;
    LocalDate data;

    public Movimento(TipoMovimento tipo, Livro livro, Usuario usuario) {
        this.tipo = tipo;
        this.livro = livro;
        this.usuario = usuario;
        this.data = LocalDate.now();
    }

    public Livro getLivro() {
        return livro;
    }

    public Usuario getUsuario() {
        return usuario;
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
