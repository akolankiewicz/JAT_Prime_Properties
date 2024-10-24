package Usuario;

import java.util.*;

public abstract class Usuario {
    private static List<Usuario> usuarios = new ArrayList<>();
    private String nome;
    private String email;
    private String senha;
    private String nivel;

    public Usuario(String nome, String email, String senha, String nivel) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.nivel = nivel;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getNivel() {
        return nivel;
    }

    // Método para cadastrar usuário
    public static void cadastrarUsuario(String nome, String email, String senha, String nivel) {
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

        // Cria um usuário genérico (anônimo) com os dados fornecidos
        Usuario novoUsuario = new Usuario(nome, email, senha, nivel) {};
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
            System.out.println("Nome: " + usuario.getNome());
            System.out.println("Email: " + usuario.getEmail());
            System.out.println("Nível: " + usuario.getNivel());
        }
    }

    // Método para login
    public static boolean fazerLogin(String email, String senha) {
        for (Usuario usuario : usuarios) { // usuarios deve ser uma lista estática de Usuario
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                System.out.println("Login realizado com sucesso!");
                return true;
            }
        }
        System.out.println("Email ou senha incorretos!");
        return false;
    }
}