import java.util.InputMismatchException;
import java.util.Scanner;

import Imovel.*;
import Usuario.*;
import Usuario.subs.Administrador;
import Usuario.subs.Comprador;
import Usuario.subs.Vendedor;

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

    // Seção onde o usuário, após logar no sistema, terá acesso ás funcionalidades
    int opcao = -1;
    while (opcao != 0) {
      try {
        if (usuarioAtual instanceof Administrador) {
          // Menu de ações do Administrador
          System.out.println("Menu de Ações (Administrador):");
          System.out.println("1. Remover Imóvel");
          System.out.println("2. Remover Usuário");
          System.out.println("3. Editar Usuário");
          System.out.println("0. Sair");
          System.out.print("Escolha uma opção: ");
          opcao = scanner.nextInt();

          // Validar a opção
          if (!verificaEntrada(1, 3, opcao)) {
            System.out.println("Opção inválida. Por favor, escolha novamente.");
            continue;
          }

          // Chamando os métodos conforme a escolha do Administrador
          switch (opcao) {
            case 1:
              System.out.println("Digite o ID do imóvel que deseja remover: ");
              int idImovelRemocao = scanner.nextInt();
              Imovel.removerImovel(idImovelRemocao);
              break;

            case 2:
              Usuario.deletarUsuario(usuarioAtual, scanner);
              break;

            case 3:
              Usuario.editarUsuario(usuarioAtual, scanner);
              break;

            case 0:
              System.out.println("Saindo...");
              break;
          }

        } else if (usuarioAtual instanceof Vendedor) {
          // Menu de ações do Vendedor
          System.out.println("Menu de Ações (Vendedor):");
          System.out.println("1. Cadastrar Imóvel");
          System.out.println("2. Editar Imóvel (Por ID)");
          System.out.println("3. Listar Imóveis");
          System.out.println("4. Deletar Imóvel (Por ID)");
          System.out.println("5. Marcar Vistoria");
          System.out.println("6. Editar Usuário");
          System.out.println("7. Deletar Usuário");
          System.out.println("0. Sair");
          System.out.print("Escolha uma opção: ");
          opcao = scanner.nextInt();

          // Validar a opção
          if (!verificaEntrada(1, 7, opcao)) {
            System.out.println("Opção inválida. Por favor, escolha novamente.");
            continue;
          }

          // Chamando os métodos conforme a escolha do Vendedor
          switch (opcao) {
            case 1:
              ((Vendedor) usuarioAtual).adicionarImovel();
              break;

            case 2:
              Imovel imovel2 = null;
              System.out.println("Digite o ID do imóvel que deseja editar");
              int idImovelEdicao = scanner.nextInt();
              for (Imovel imovelListado : ((Vendedor) usuarioAtual).imoveis) {
                if (imovelListado.getId() == idImovelEdicao) {
                  imovel2 = imovelListado;
                }
              }
              ((Vendedor) usuarioAtual).editarImovel(imovel2);
              break;

            case 3:
              ((Vendedor) usuarioAtual).listarImoveis();
              break;

            case 4:
              Imovel imovel4 = null;
              System.out.println("Digite o ID do imóvel que deseja remover");
              int idImovelRemocao = scanner.nextInt();
              for (Imovel imovelListado : ((Vendedor) usuarioAtual).imoveis) {
                if (imovelListado.getId() == idImovelRemocao) {
                  imovel4 = imovelListado;
                }
              }
              ((Vendedor) usuarioAtual).deletarImovel(imovel4);
              break;

            case 5:

              // ((Vendedor) usuarioAtual).marcarVistoria();
              break;

            case 6:
              Usuario.editarUsuario(usuarioAtual, scanner);
              break;

            case 7:
              Usuario.deletarUsuario(usuarioAtual, scanner);
              break;

            case 0:
              System.out.println("Saindo...");
              break;
          }

        } else if (usuarioAtual instanceof Comprador) {
          // Menu de ações do Comprador
          System.out.println("Menu de Ações (Comprador):");
          System.out.println("1. Alugar Imóvel");
          System.out.println("2. Comprar Imóvel");
          System.out.println("3. Marcar Visita");
          System.out.println("4. Editar Usuário");
          System.out.println("5. Deletar Usuário");
          System.out.println("0. Sair");
          System.out.print("Escolha uma opção: ");
          opcao = scanner.nextInt();

          if (!verificaEntrada(1, 5, opcao)) {
            System.out.println("Opção inválida. Por favor, escolha novamente.");
            continue;
          }

          // Chamando os métodos conforme a escolha do Comprador
          switch (opcao) {
            case 1:
              System.out.println("Digite o ID do imóvel que deseja alugar");
              int idImovelAluguel = scanner.nextInt();
              ((Comprador) usuarioAtual).alugarImovel(idImovelAluguel);
              break;

            case 2:
              System.out.println("Digite o ID do imóvel que deseja comprar");
              int idImovelComprar = scanner.nextInt();
              ((Comprador) usuarioAtual).comprarImovel(idImovelComprar);
              break;

            case 3:
              // marcarVisita();
              break;

            case 4:
              Usuario.editarUsuario(usuarioAtual, scanner);
              break;

            case 5:
              Usuario.deletarUsuario(usuarioAtual, scanner);
              break;

            case 0:
              System.out.println("Saindo...");
              break;
          }
        }
      } catch (Exception e) {
        // Caso o usuário digite algo errado (ex: uma string ao invés de um número)
        System.out.println("Entrada inválida! Por favor, digite um número válido.");
        scanner.nextLine();
        opcao = -1;
      }

      System.out.println("Usuário atual: " + usuarioAtual.getNome() + " - ID: " + usuarioAtual.getId());
      scanner.close();
    }

  }

  public static boolean verificaEntrada(int menor, int maior, int entrada) {
    if (entrada == 0) {
      return true;
    }
    if (entrada >= menor && entrada <= maior) {
      return true;
    } else {
      return false;
    }
  }

}
