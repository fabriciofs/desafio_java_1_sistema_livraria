package br.com.livraria_foguete.views;

import br.com.livraria_foguete.models.Livro;
import br.com.livraria_foguete.models.Usuario;
import br.com.livraria_foguete.services.LivrosService;
import br.com.livraria_foguete.services.MovimentosService;
import br.com.livraria_foguete.services.UsuariosService;

public class Operacao {

    LivrosService livrosService;
    UsuariosService usuariosService;
    MovimentosService movimentosService;

    public Operacao() {
        this.livrosService = new LivrosService();
        this.usuariosService = new UsuariosService();
        this.movimentosService = new MovimentosService();
    }

    public void executar() {
        System.out.println("Bem-vindo à Livraria Foguete!");

        int opcao = 0;
        while (opcao != 5) {
            exibirMenu();
            opcao = new java.util.Scanner(System.in).nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Cadastrar Livro");
                    try {
                        cadastrarLivro();
                    } catch (Exception e) {
                        System.out.println("Erro ao cadastrar livro: " + e.getMessage());
                    }
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        System.out.println("Erro ao esperar: " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Cadastrar Usuario");
                    try {
                        cadastrarUsuario();
                    } catch (Exception e) {
                        System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
                    }
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        System.out.println("Erro ao esperar: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Emprestar Livro");
                    try {
                        EmprestarLivro();
                    } catch (Exception e) {
                        System.out.println("Erro ao emprestar livro: " + e.getMessage());
                    }
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        System.out.println("Erro ao esperar: " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Devolver Livro");
                    try {
                        DevolverLivro();
                    } catch (Exception e) {
                        System.out.println("Erro ao devolver livro: " + e.getMessage());
                    }
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        System.out.println("Erro ao esperar: " + e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void exibirMenu() {
        System.out.println("=================================");
        System.out.println("Menu da Livraria Foguete:");
        System.out.println("1. Cadastrar Livro");
        System.out.println("2. Cadastrar Usuario");
        System.out.println("3. Emprestar Livro");
        System.out.println("4. Devolver Livro");
        System.out.println("5. Sair");
        System.out.println("=================================");
        System.out.println("Selecione uma opção:");
    }

    private void cadastrarLivro() {
        System.out.println("Cadastrar Livro");
        System.out.println("---------------");
        System.out.print("Nome do Livro: ");
        String nomeLivro = new java.util.Scanner(System.in).nextLine();
        System.out.print("Autor do Livro: ");
        String autorLivro = new java.util.Scanner(System.in).nextLine();
        System.out.print("Ano de Publicação: ");
        int anoPublicacao = new java.util.Scanner(System.in).nextInt();

        this.livrosService.adicionarLivro(nomeLivro, autorLivro, anoPublicacao);
    }

    private void cadastrarUsuario() {
        System.out.println("Cadastrar Usuario");
        System.out.println("------------------");
        System.out.print("Nome do Usuario: ");
        String nomeUsuario = new java.util.Scanner(System.in).nextLine();
        System.out.print("Email do Usuario: ");
        String emailUsuario = new java.util.Scanner(System.in).nextLine();
        System.out.print("Telefone do Usuario: ");
        String telefoneUsuario = new java.util.Scanner(System.in).nextLine();

        this.usuariosService.cadastrarUsuario(nomeUsuario, emailUsuario, telefoneUsuario);
    }

    private void EmprestarLivro() {

        System.out.println("Emprestar Livro");
        System.out.println("----------------");
        this.livrosService.listarLivros();

        System.out.print("Digite o ID do livro que deseja emprestar: ");
        int idLivro = new java.util.Scanner(System.in).nextInt();

        if (idLivro < 0 || idLivro >= this.livrosService.getLivros().size()) {
            System.out.println("ID inválido. Tente novamente.");
            return;
        }

        Livro livro =  this.livrosService.buscarLivroPorId(idLivro);

        if (livro == null) {
            throw new IllegalStateException("Livro não encontrado.");
        }

        this.usuariosService.listarUsuarios();
        System.out.print("Digite o ID do usuário que deseja emprestar o livro: ");
        int idUsuario = new java.util.Scanner(System.in).nextInt();
        if (idUsuario < 0 || idUsuario >= this.usuariosService.getUsuarios().size()) {
            System.out.println("ID inválido. Tente novamente.");
            return;
        }

        Usuario usuario = this.usuariosService.buscarUsuarioPorId(idUsuario);
        if (usuario == null) {
            throw new IllegalStateException("Usuário não encontrado.");
        }

        try {
            this.movimentosService.emprestarLivro(livro, usuario);
            System.out.println("Livro emprestado com sucesso!");
        } catch (IllegalStateException e) {
            System.out.println("Erro ao emprestar livro: " + e.getMessage());
        }
    }

    private void DevolverLivro() {
        System.out.println("Devolver Livro");
        System.out.println("---------------");
        this.livrosService.listarLivros();

        System.out.print("Digite o ID do livro que deseja devolver: ");
        int idLivro = new java.util.Scanner(System.in).nextInt();

        if (idLivro < 0 || idLivro >= this.livrosService.getLivros().size()) {
            System.out.println("ID inválido. Tente novamente.");
            return;
        }

        Livro livro = this.livrosService.buscarLivroPorId(idLivro);
        if (livro == null) {
            throw new IllegalStateException("Livro não encontrado.");
        }

        this.usuariosService.listarUsuarios();
        System.out.print("Digite o ID do usuário que deseja devolver o livro: ");
        int idUsuario = new java.util.Scanner(System.in).nextInt();
        if (idUsuario < 0 || idUsuario >= this.usuariosService.getUsuarios().size()) {
            System.out.println("ID inválido. Tente novamente.");
            return;
        }

        Usuario usuario = this.usuariosService.buscarUsuarioPorId(idUsuario);
        if (usuario == null) {
            throw new IllegalStateException("Usuário não encontrado.");
        }

        try {
            this.movimentosService.devolverLivro(livro, usuario);
            System.out.println("Livro devolvido com sucesso!");
        } catch (IllegalStateException e) {
            System.out.println("Erro ao devolver livro: " + e.getMessage());
        }
    }

}
