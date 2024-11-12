import java.util.InputMismatchException;
import java.util.Scanner;

import Imovel.*;
import Usuario.*;
import Usuario.subs.Administrador;
import Usuario.subs.Comprador;
import Usuario.subs.Vendedor;
import Visita.*;

public class MAIN {
  public static void main(String[] args) {
    // Paramêtros Globais (Objetos que representam usuário logado)
    Scanner scanner = new Scanner(System.in);
    Usuario usuarioAtual = null;

    // Seção de login/cadastro
    int login_feito = 0;
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

    // Seção onde o usuário, após logar no sistema, terá acesso as funcionalidades
    int opcao = -1;
    while (opcao != 0) {
      if (usuarioAtual instanceof Administrador) {
        // eu q mando nessa poha
        System.out.println("Menu de Ações:");
        System.out.println("1. Remover Imóvel");
        System.out.println("2. Remover Usuário");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
        opcao = scanner.nextInt();
      }

      if (usuarioAtual instanceof Vendedor) {
        System.out.println("Menu de Ações:");
        System.out.println("1. Cadastrar Imóvel");
        System.out.println("2. Editar Imóvel");
        System.out.println("3. Listar Imóveis");
        System.out.println("4. Deletar Imóvel");
        System.out.println("5. Marcar Vistoria");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
        opcao = scanner.nextInt();
      }

      if (usuarioAtual instanceof Comprador) {
        System.out.println("Menu de Ações:");
        System.out.println("1. Alugar Imóvel");
        System.out.println("2. Comprar Imóvel");
        System.out.println("3. Marcar Visita");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
        opcao = scanner.nextInt();
      }
      if (opcao < 1 || opcao > 3) {
        System.out.println("Opção inválida. Por favor, escolha novamente.");
        opcao = 0;
      }

      if (opcao == 3) { // Se o usuário escolher visitar
        VisitaEAvaliacao visitaEAvaliacao = new VisitaEAvaliacao(usuarioAtual);
        visitaEAvaliacao.agendarVisita(Imovel.getListaImoveis()); // Implemente um método getListaImoveis() que retorne
      }
    }
    System.out.println("User atual " + usuarioAtual.getNome() + usuarioAtual.getId());
    scanner.close();
  }
}
