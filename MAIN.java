import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;

import java.util.Scanner;
import Imovel.*;
import Imovel.subs.Casa;
import Usuario.*;
import Usuario.subs.Administrador;
import Usuario.subs.Comprador;
import Usuario.subs.Vendedor;
import Agendamento.subs.Visita;
import Agendamento.subs.Vistoria;

public class MAIN {
  public static void main(String[] args) {
    // Paramêtros Globais (Objetos que representam usuário logado)
    Scanner scanner = new Scanner(System.in);
    Usuario usuarioAtual = null;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    Casa casa = new Casa("Belo Horizonte", "Centro", "Rua A", 100, 120, 2000, 500, 350000, 2020, 3, 2, true, true, true,
        true, true);
    Imovel.getListaImoveis().add(casa);

    int login_feito;
    while (true) {
      login_feito = 0;
      while (login_feito == 0) {
        try {
          System.out.println("\n=== Menu Principal ===");
          System.out.println("1. Login");
          System.out.println("2. Cadastro");
          login_feito = scanner.nextInt();
          scanner.nextLine();

          if (login_feito == 1) {
            System.out.print("Digite seu email: ");
            String email = scanner.nextLine();
            System.out.print("Digite sua senha: ");
            String senha = scanner.nextLine();
            usuarioAtual = Usuario.fazerLogin(email, senha);

            if (usuarioAtual != null) {
              System.out.println("Bem-vindo, " + usuarioAtual.getNome() + "!");
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
          scanner.nextLine();
          login_feito = 0;
        }
      }

      // Seção onde o usuário, após logar no sistema, terá acesso às funcionalidades
      int opcao = -1;
      while (opcao != 0) {
        if (opcao == 666) {
          break;
        }
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
            scanner.nextLine();

            if (!verificaEntrada(1, 3, opcao)) {
              System.out.println("Opção inválida. Por favor, escolha novamente.");
              continue;
            }

            switch (opcao) {
              case 1:
                System.out.print("Digite o ID do imóvel que deseja remover: ");
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
            scanner.nextLine();

            if (!verificaEntrada(1, 7, opcao)) {
              System.out.println("Opção inválida. Por favor, escolha novamente.");
              continue;
            }

            switch (opcao) {
              case 1:
                ((Vendedor) usuarioAtual).adicionarImovel();
                break;

              case 2:
                System.out.print("Digite o ID do imóvel que deseja editar: ");
                int idImovelEdicao = scanner.nextInt();
                scanner.nextLine();
                Imovel imovel2 = ((Vendedor) usuarioAtual).imoveis.stream()
                    .filter(i -> i.getId() == idImovelEdicao)
                    .findFirst()
                    .orElse(null);
                ((Vendedor) usuarioAtual).editarImovel(imovel2);
                break;

              case 3:
                ((Vendedor) usuarioAtual).listarImoveis();
                break;

              case 4:
                System.out.print("Digite o ID do imóvel que deseja remover: ");
                int idImovelRem = scanner.nextInt();
                scanner.nextLine();
                Imovel imovel4 = ((Vendedor) usuarioAtual).imoveis.stream()
                    .filter(i -> i.getId() == idImovelRem)
                    .findFirst()
                    .orElse(null);
                ((Vendedor) usuarioAtual).deletarImovel(imovel4);
                break;

              case 5:
                System.out.print("Digite o ID do imóvel para agendar a vistoria (ex: " + casa.getId() + "): ");
                int idImovelVistoria = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Digite a data da vistoria (Formato: YYYY-MM-DD): ");
                String dataVistoriaStr = scanner.nextLine();
                System.out.print("Digite o horário da vistoria (Formato: HH:mm): ");
                String horaVistoriaStr = scanner.nextLine();

                try {
                  Date dataVistoria = sdf.parse(dataVistoriaStr + " " + horaVistoriaStr);
                  Vistoria vistoria = new Vistoria(idImovelVistoria, dataVistoria);
                  vistoria.agendarVistoria(idImovelVistoria, dataVistoria);
                } catch (Exception e) {
                  System.out
                      .println("Erro ao agendar vistoria. Certifique-se de usar o formato correto de data e hora.");
                }
                continue;

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
            System.out.println("1. Listar Imóveis");
            System.out.println("2. Alugar Imóvel");
            System.out.println("3. Comprar Imóvel");
            System.out.println("4. Marcar Visita");
            System.out.println("5. Editar Usuário");
            System.out.println("6. Deletar Usuário");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            if (!verificaEntrada(1, 6, opcao)) {
              System.out.println("Opção inválida. Por favor, escolha novamente.");
              continue;
            }

            switch (opcao) {
              case 1:
                Imovel.listarImoveis();
                break;

              case 2:
                System.out.print("Digite o ID do imóvel que deseja alugar: ");
                int idImovelAluguel = scanner.nextInt();
                ((Comprador) usuarioAtual).alugarImovel(idImovelAluguel);
                break;

              case 3:
                System.out.print("Digite o ID do imóvel que deseja comprar: ");
                int idImovelComprar = scanner.nextInt();
                ((Comprador) usuarioAtual).comprarImovel(idImovelComprar);
                break;

              case 4:
                System.out.print("Digite o ID do imóvel que deseja visitar (ex: " + casa.getId() + "): ");
                int idImovelVisita = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Digite a data da visita (Formato: YYYY-MM-DD): ");
                String dataVisitaStr = scanner.nextLine();
                System.out.print("Digite o horário da visita (Formato: HH:mm): ");
                String horaVisitaStr = scanner.nextLine();

                try {
                  Date dataVisita = sdf.parse(dataVisitaStr + " " + horaVisitaStr);
                  Visita visita = new Visita(idImovelVisita, dataVisita);
                  visita.agendarVisita(idImovelVisita, dataVisita);
                } catch (Exception e) {
                  System.out.println("Erro ao agendar visita. Certifique-se de usar o formato correto de data e hora.");
                }
                continue;

              case 5:
                Usuario.editarUsuario(usuarioAtual, scanner);
                break;

              case 6:
                Usuario.deletarUsuario(usuarioAtual, scanner);
                opcao = 666;
                break;

              case 0:
                System.out.println("Saindo...");
                break;
            }
          }
        } catch (InputMismatchException e) {
          System.out.println("Por favor, digite uma entrada válida.");
          scanner.nextLine();
        }
      }
    }
  }

  // Função auxiliar para verificar se a opção está dentro do intervalo esperado
  public static boolean verificaEntrada(int min, int max, int opcao) {
    return opcao >= min && opcao <= max || opcao == 0;
  }
}
