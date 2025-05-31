package br.com.livraria_foguete.services;

import br.com.livraria_foguete.models.Livro;

import java.util.ArrayList;

public class LivrosService {

    ArrayList<Livro> livros;

    public ArrayList<Livro> getLivros() {
        return livros;
    }

    public void adicionarLivro(String titulo, String autor, int anoPublicacao) {
        Livro novoLivro = new Livro(titulo, autor, anoPublicacao);
        if (livros == null) {
            livros = new ArrayList<>();
        }
        livros.add(novoLivro);
        System.out.println("Livro cadastrado com sucesso: " + novoLivro);
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

    public Livro buscarLivroPorId(int id) {
        if (livros == null || id < 0 || id >= livros.size()) {
            return null;
        }
        return livros.get(id);
    }
}
