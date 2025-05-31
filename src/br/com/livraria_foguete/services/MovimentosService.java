package br.com.livraria_foguete.services;

import br.com.livraria_foguete.models.*;

import java.util.ArrayList;

public class MovimentosService {

    ArrayList<Movimento> movimentos;

    public void emprestarLivro(Livro livro, Usuario usuario) {
        if(livro.getStatus() != StatusLivro.DISPONIVEL) {
            throw new IllegalStateException("Livro não está disponível para empréstimo.");
        }
        livro.setStatus(StatusLivro.EMPRESTADO);
        Movimento novoMovimento = new Movimento(TipoMovimento.EMPRESTIMO,livro, usuario );
    }

    public void devolverLivro(Livro livro, Usuario usuario) {
        if(livro.getStatus() != StatusLivro.EMPRESTADO) {
            throw new IllegalStateException("Livro não está emprestado.");
        }
        livro.setStatus(StatusLivro.DISPONIVEL);
        Movimento novoMovimento = new Movimento(TipoMovimento.DEVOLUCAO, livro, usuario);
    }

    public void listarMovimentosPorLivro(Livro livro) {
        if (movimentos == null || movimentos.isEmpty()) {
            System.out.println("Nenhum movimento registrado.");
            return;
        }
        for (Movimento movimento : movimentos) {
            if (movimento.getLivro().equals(livro)) {
                System.out.println(movimento);
            }
        }
    }

    public void listarMovimentosPorUsuario(Usuario usuario) {
        if (movimentos == null || movimentos.isEmpty()) {
            System.out.println("Nenhum movimento registrado.");
            return;
        }
        for (Movimento movimento : movimentos) {
            if (movimento.getUsuario().equals(usuario)) {
                System.out.println(movimento);
            }
        }
    }
}
