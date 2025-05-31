package br.com.livraria_foguete.services;

import br.com.livraria_foguete.models.Livro;

import java.util.ArrayList;

public class LivrosService {

    ArrayList<Livro> livros;

    public void adicionarLivro(String titulo, String autor, String genero, int anoPublicacao) {
        Livro novoLivro = new Livro(titulo, autor, genero, anoPublicacao);
        if (livros == null) {
            livros = new ArrayList<>();
        }
        livros.add(novoLivro);
    }

    public void removerLivro(Livro livro) {
        if (livros != null) {
            livros.remove(livro);
        }
    }

    public void listarLivros() {
        if (livros == null || livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
            return;
        }
        for (int i = 0; i < livros.size(); i++) {
            Livro livro = livros.get(i);
            System.out.println("ID: " + i + " - " + livro);
        }
    }
}
