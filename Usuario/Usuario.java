package Usuario;

import Usuario.subs.Administrador;
import Usuario.subs.Clientes.Comprador;
import Usuario.subs.Clientes.Vendedor;
import java.util.*;

public abstract class Usuario {
    private static List<Usuario> usuarios = new ArrayList<>(); 
    private static int idCounter = 1; // Contador para IDs únicos
    private int id; // ID único para cada usuário
    private String nome;
    private String email;
    private String senha;

    public Usuario(String nome, String email, String senha) {
        this.id = idCounter++; // Atribui o ID e incrementa o contador
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    // Getters e Setters
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

    // Método para cadastrar usuário
    public static void cadastrarUsuario(String nome, String email, String senha, String tipoUsuario) {
        // Validações básicas
        if (nome == null || nome.trim().isEmpty() || 
            email == null || email.trim().isEmpty() || 
            senha == null || senha.trim().isEmpty()) {
            System.out.println("Erro: Todos os campos são obrigatórios!");
            return;
        }

        // Verifica se email já existe
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
            case "administrador":
                novoUsuario = new Administrador(nome, email, senha);
                break;
            default:
                System.out.println("Erro: Tipo de usuário inválido! Deve ser 'vendedor', 'cliente' ou 'administrador'.");
                return;
        }

        // Adiciona o novo usuário à lista
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

    // Método para listar usuários
    public static void listarUsuarios() {
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

    // Método para login
    public static Usuario fazerLogin(String email, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                System.out.println("Login realizado com sucesso!");
                return usuario; // Retorna o usuário logado
            }
        }
        System.out.println("Email ou senha incorretos!");
        return null; // Retorna null se o login falhar
    }
}