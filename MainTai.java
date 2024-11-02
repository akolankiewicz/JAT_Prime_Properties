import Usuario.*; 
import java.util.InputMismatchException;
import java.util.Scanner;

import Imovel.Imovel;

public class MainTai {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        int login_feito = 0; 
        int opcao = 0; 
        Usuario usuarioAtual = null;

        // Menu de Login e Cadastro
        while (login_feito == 0) {
            try {
                System.out.println("\n=== Menu Principal ===");
                System.out.println("1. Login");
                System.out.println("2. Cadastro");
                System.out.print("Escolha uma opção: ");
                login_feito = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer

                if (login_feito == 1) {
                    System.out.print("Digite seu email: ");
                    String email = scanner.nextLine();
                    System.out.print("Digite sua senha: ");
                    String senha = scanner.nextLine();

                    usuarioAtual = Usuario.fazerLogin(email, senha); 

                    if (usuarioAtual != null) {
                        System.out.println("Bem-vindo, " + usuarioAtual.getNome() + "!");
                    
                        login_feito = 1; 
                    } else {
                        System.out.println("Email ou senha incorretos. Tente novamente.");
                        login_feito = 0; // Volta ao menu se o login falhar
                    }

                } else if (login_feito == 2) {
                    System.out.print("Digite seu nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite seu email: ");
                    String email = scanner.nextLine();
                    System.out.print("Digite sua senha: ");
                    String senha = scanner.nextLine();
                    System.out.print("Deseja se cadastrar como vendedor ou cliente? ");
                    String tipoUsuario = scanner.nextLine(); 

                    Usuario.cadastrarUsuario(nome, email, senha, tipoUsuario);
                    login_feito = 0; // Volta ao menu após o cadastro

                } else {
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
                    login_feito = 0;
                }

            } catch (InputMismatchException e) {
                System.out.println("Por favor, digite um número válido.");
                scanner.nextLine(); // Limpa o buffer
                login_feito = 0;
            }
        }

        while (opcao == 0) {
            System.out.println("Menu de Ações:");
            System.out.println("1. Alugar");
            System.out.println("2. Comprar");
            System.out.println("3. Visitar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt(); 

            if (opcao < 1 || opcao > 3) {
                System.out.println("Opção inválida. Por favor, escolha novamente."); 
                opcao = 0; 
            }

            if (opcao == 3) { // Se o usuário escolher visitar
            VisitaEAvaliacao visitaEAvaliacao = new VisitaEAvaliacao(usuarioAtual);
            visitaEAvaliacao.agendarVisita(Imovel.getListaImoveis()); // Implemente um método getListaImoveis() que retorne a lista de imóveis
            }
        }
        System.out.println("User atual " + usuarioAtual.getNome() + usuarioAtual.getId());
        scanner.close();
    }
}