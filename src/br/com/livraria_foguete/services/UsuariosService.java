package br.com.livraria_foguete.services;

import br.com.livraria_foguete.models.Livro;
import br.com.livraria_foguete.models.Usuario;

import java.util.ArrayList;

public class UsuariosService {

    ArrayList<Usuario> usuarios;

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void cadastrarUsuario(String nome, String email, String telefone) {
        if (usuarios == null) {
            usuarios = new ArrayList<>();
        }

        Usuario usuario = new Usuario(nome, email, telefone);
        usuarios.add(usuario);
        System.out.println("Usuário cadastrado com sucesso: " + usuario);
    }

    public void listarUsuarios() {
        if (usuarios == null || usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
            return;
        }

        System.out.println("Lista de Usuários:");
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario usuario = usuarios.get(i);
            System.out.println("ID: " + i + " - " + usuario);
        }
    }

    public Usuario buscarUsuarioPorId(int id) {
        if (usuarios == null || id < 0 || id >= usuarios.size()) {
            return null;
        }
        return usuarios.get(id);
    }

}
