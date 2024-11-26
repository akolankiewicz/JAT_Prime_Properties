package Usuario;

import Usuario.subs.Administrador;
import Usuario.subs.Comprador;
import Usuario.subs.Vendedor;
import java.util.*;

public abstract class Usuario {
    private static List<Usuario> usuarios = new ArrayList<>();
    private static int idCounter = 0;
    private int id;
    private String nome;
    private String email;
    private String senha;

    public Usuario(String nome, String email, String senha) {
        this.id = ++idCounter;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public static List<Usuario> getListaUsuarios() {
        return usuarios;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public static void cadastrarUsuario(String nome, String email, String senha, String tipoUsuario) {

        if (nome == null || nome.trim().isEmpty() ||
                email == null || email.trim().isEmpty() ||
                senha == null || senha.trim().isEmpty()) {
            System.out.println("Erro: Todos os campos são obrigatórios!");
            return;
        }

        if (emailJaCadastrado(email)) {
            System.out.println("Erro: Email já cadastrado!");
            return;
        }

        Usuario novoUsuario = null;

        switch (tipoUsuario.toLowerCase()) {
            case "vendedor":
                novoUsuario = new Vendedor(nome, email, senha);
                break;
            case "cliente":
                novoUsuario = new Comprador(nome, email, senha);
                break;
            default:
                System.out
                        .println("Erro: Tipo de usuário inválido! Deve ser 'vendedor', 'cliente'.");
                return;
        }

        usuarios.add(novoUsuario);
        System.out.println("Usuário cadastrado com sucesso!");
    }

    private static boolean emailJaCadastrado(String email) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public static void informacaoUsuario(Usuario usuarioLogado, Scanner sc) {
        if (usuarioLogado instanceof Administrador) {
            System.out.println("Você é um administrador. Deseja listar todos os usuários ou de um tipo específico?");
            System.out.println("1. Listar todos os usuários");
            System.out.println("2. Listar usuários por tipo (vendedor, comprador, administrador)");
            int escolha = sc.nextInt();
            sc.nextLine();

            if (escolha == 1) {
                listarTodosUsuarios();
            } else if (escolha == 2) {
                System.out.println("Digite o tipo de usuário que deseja listar (vendedor, comprador, administrador):");
                String tipo = sc.nextLine().trim().toLowerCase();
                listarUsuariosPorTipo(tipo);
            } else {
                System.out.println("Opção inválida.");
            }
        } else {
            System.out.println("------------------------");
            System.out.println("ID: " + usuarioLogado.getId());
            System.out.println("Nome: " + usuarioLogado.getNome());
            System.out.println("Email: " + usuarioLogado.getEmail());
        }
    }

    private static void listarTodosUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
            return;
        }

        System.out.println("\nLista de Usuários:");
        for (Usuario usuario : usuarios) {
            System.out.println("------------------------");
            System.out.println("ID: " + usuario.getId());
            System.out.println("Nome: " + usuario.getNome());
            System.out.println("Email: " + usuario.getEmail());
        }
    }

    private static void listarUsuariosPorTipo(String tipo) {
        boolean encontrou = false;

        for (Usuario usuario : usuarios) {
            if (tipo.equals("vendedor") && usuario instanceof Vendedor) {
                System.out.println("------------------------");
                System.out.println("ID: " + usuario.getId());
                System.out.println("Nome: " + usuario.getNome());
                System.out.println("Email: " + usuario.getEmail());
                encontrou = true;
            } else if (tipo.equals("comprador") && usuario instanceof Comprador) {
                System.out.println("------------------------");
                System.out.println("ID: " + usuario.getId());
                System.out.println("Nome: " + usuario.getNome());
                System.out.println("Email: " + usuario.getEmail());
                encontrou = true;
            } else if (tipo.equals("administrador") && usuario instanceof Administrador) {
                System.out.println("------------------------");
                System.out.println("ID: " + usuario.getId());
                System.out.println("Nome: " + usuario.getNome());
                System.out.println("Email: " + usuario.getEmail());
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum usuário do tipo " + tipo + " encontrado.");
        }
    }

    public static Usuario fazerLogin(String email, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                System.out.println("Login realizado com sucesso!");
                return usuario;
            }
        }
        System.out.println("Email ou senha incorretos!");
        return null;
    }

    public static void editarUsuario(Usuario usuarioLogado, Scanner sc) {
        Usuario usuarioParaEditar = null;

        if (usuarioLogado instanceof Administrador) {
            System.out.println("Qual ID do usuário que deseja alterar? ");
            int idEscolhido = sc.nextInt();
            usuarioParaEditar = buscarUsuarioPorId(idEscolhido);
        } else {
            usuarioParaEditar = usuarioLogado;
        }

        if (usuarioParaEditar == null) {
            System.out.println("Erro: Usuário não encontrado!");
            return;
        }

        System.out.println("Digite o novo nome (deixe em branco para não alterar): ");
        String novoNome = sc.nextLine();
        if (novoNome != null && !novoNome.trim().isEmpty()) {
            usuarioParaEditar.setNome(novoNome);
        }

        String novoEmail = null;
        boolean emailValido = false;
        while (!emailValido) {
            System.out.println("Digite o novo email (deixe em branco para não alterar): ");
            novoEmail = sc.nextLine();
            if (novoEmail.trim().isEmpty()) {
                emailValido = true; // Deixa o email como está se não for informado um novo
            } else if (!usuarioParaEditar.getEmail().equals(novoEmail) && emailJaCadastrado(novoEmail)) {
                System.out.println("Erro: Email já cadastrado! Tente outro.");
            } else {
                emailValido = true;
                usuarioParaEditar.setEmail(novoEmail);
            }
        }

        System.out.println("Digite a nova senha (deixe em branco para não alterar): ");
        String novaSenha = sc.nextLine();
        if (novaSenha != null && !novaSenha.trim().isEmpty()) {
            usuarioParaEditar.setSenha(novaSenha);
        }

        System.out.println("Usuário editado com sucesso!");
    }

    public static void deletarUsuario(Usuario usuarioLogado, Scanner sc) {
        Usuario usuarioParaDeletar = null;

        if (usuarioLogado instanceof Administrador) {
            System.out.println("Qual ID do usuário que deseja deletar? ");
            int idEscolhido = sc.nextInt();
            usuarioParaDeletar = buscarUsuarioPorId(idEscolhido);
        } else {
            usuarioParaDeletar = usuarioLogado;
        }

        if (usuarioParaDeletar == null) {
            System.out.println("Erro: Usuário não encontrado!");
            return;
        }

        usuarios.remove(usuarioParaDeletar);
        System.out.println("Usuário deletado com sucesso!");
    }

    private static Usuario buscarUsuarioPorId(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }
}
