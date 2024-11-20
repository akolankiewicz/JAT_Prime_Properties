import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import Imovel.*;
import Imovel.subs.Casa;
import Imovel.subs.Apartamento;
import Imovel.subs.Comercial;
import Imovel.subs.Pavilhao;
import Usuario.*;
import Usuario.subs.Administrador;
import Usuario.subs.Comprador;
import Usuario.subs.Vendedor;
import Agendamento.*;
import Agendamento.subs.Visita;
import Agendamento.subs.Vistoria;

public class MAIN {
  public static void main(String[] args) {
    // Paramêtros Globais (Objetos que representam usuário logado)
    Scanner scanner = new Scanner(System.in);
    Usuario usuarioAtual = null;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    Casa casa = new Casa("Belo Horizonte", "Centro", "Rua A", 100, 120, 2000, 500, 350000, 2020, 3, 2, true, true, true, true, true);
    Comprador comprador = new Comprador("Comprador Teste", "comprador@example.com", "123");
    Vendedor vendedor = new Vendedor("Vendedor Teste", "vendedor@example.com", "senha123");

    // Seção de login/cadastro
    int login_feito = 0;
    while (login_feito == 0) {
      try {
        System.out.println("\n=== Menu Principal ===");
        System.out.println("1. Login");
        System.out.println("2. Cadastro");
        try {
          login_feito = scanner.nextInt();
          scanner.nextLine(); // Limpar o buffer
      } catch (InputMismatchException e) {
          System.out.println("Por favor, digite um número válido.");
          scanner.nextLine(); // Limpar o buffer
          login_feito = 0; // Continuar no loop
          continue;
      }

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
      try {
        if (usuarioAtual instanceof Administrador) {
          // Menu de ações do Administrador
          System.out.println("Menu de Ações (Administrador):");
          System.out.println("1. Remover Imóvel");
          System.out.println("2. Remover Usuário");
          System.out.println("3. Editar Usuário");
          System.out.println("0. Sair");
          System.out.print("Escolha uma opção: ");
        try {
          opcao = scanner.nextInt();
          scanner.nextLine(); // Limpar o buffer
        } catch (InputMismatchException e) {
          System.out.println("Por favor, digite um número válido.");
          scanner.nextLine(); // Limpar o buffer
          opcao = -1; // Continuar no loop
          continue;
        }

          // Validar a opção
          if (opcao < 0 || opcao > 2) {
            System.out.println("Opção inválida. Por favor, escolha novamente.");
            continue; // Voltar para o início do loop e exibir novamente o menu
          }

          // Chamando os métodos conforme a escolha do Administrador
          switch (opcao) {
            case 1:
              // removerImovel();
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
          try {
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer
          } catch (InputMismatchException e) {
              System.out.println("Por favor, digite um número válido.");
              scanner.nextLine(); // Limpar o buffer
              opcao = -1; // Continuar no loop
              continue;
            }

          // Validar a opção
          if (opcao < 0 || opcao > 6) {
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
                    // Agendar vistoria
                    System.out.print("Digite o ID do imóvel para agendar a vistoria (ex: " + casa.getId() + "): ");
                    int idImovelVistoria = scanner.nextInt();

                    // Solicitar data para a vistoria
                    scanner.nextLine(); // Limpar o buffer
                    System.out.print("Digite a data da vistoria (Formato: YYYY-MM-DD): ");
                    String dataVistoriaStr = scanner.nextLine();
                    System.out.print("Digite o horário da vistoria (Formato: HH:mm): ");
                    String horaVistoriaStr = scanner.nextLine();

                    try {
                        // Combinar a data e o horário para convertê-los em Date
                        String dataHoraVistoriaStr = dataVistoriaStr + " " + horaVistoriaStr;

                        // Verificar a string antes de converter
                        System.out.println("Tentando converter a string: " + dataHoraVistoriaStr);

                        // Converter para Date
                        Date dataVistoria = sdf.parse(dataHoraVistoriaStr);

                        // Agendar vistoria sem a verificação de disponibilidade
                        Vistoria vistoria = new Vistoria(idImovelVistoria, dataVistoria);
                        vistoria.agendarVistoria(idImovelVistoria, dataVistoria);
                    } catch (Exception e) {
                        System.out.println("Erro ao agendar vistoria. Certifique-se de usar o formato correto de data e hora.");
                        e.printStackTrace(); // Exibir a stack trace do erro
                    }
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
          try {
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer
        } catch (InputMismatchException e) {
            System.out.println("Por favor, digite um número válido.");
            scanner.nextLine(); // Limpar o buffer
            opcao = -1; // Continuar no loop
            continue;
        }
      
          // Validar a opç2ão
          if (opcao < 0 || opcao > 5) {
              System.out.println("Opção inválida. Por favor, escolha novamente.");
              continue;
          }
          // Validar a opção
          if (opcao < 0 || opcao > 4) {
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
            try {
                System.out.print("Digite o ID do imóvel que deseja visitar (ex: " + casa.getId() + "): ");
                int idImovelVisita = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer após nextInt()
        
                // Solicitar data para a visita
                System.out.print("Digite a data da visita (Formato: YYYY-MM-DD): ");
                String dataVisitaStr = scanner.nextLine();
                System.out.print("Digite o horário da visita (Formato: HH:mm): ");
                String horaVisitaStr = scanner.nextLine();
        
                String dataHoraStr = dataVisitaStr + " " + horaVisitaStr;
                Date dataVisita = sdf.parse(dataHoraStr); // Tentativa de converter a string para Date
                System.out.println("Visita agendada para o imóvel ID: " + idImovelVisita + " na data " + dataVisita);
        
                // Criar e agendar a visita
                Visita visita = new Visita(idImovelVisita, dataVisita);
                visita.agendarVisitaComValidade(casa, comprador, dataVisita);
        
                System.out.println("Visita agendada com sucesso! Retornando ao menu do cliente...");
            } catch (Exception e) {
                System.out.println("Erro ao agendar visita. Certifique-se de usar o formato correto de data e hora.");
                e.printStackTrace();
            }
            break; // Volta ao menu do cliente

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
        scanner.nextLine(); // Limpar o buffer de entrada
        opcao = -1; // Manter a opção em -1 para continuar o loop
      }

      // Após qualquer operação, mostrar o nome e o ID do usuário atual
      System.out.println("Usuário atual: " + usuarioAtual.getNome() + " - ID: " + usuarioAtual.getId());
      scanner.close();
    }
  }


  // public boolean verificaEntrada(int menor, int maior, int entrada) {
  // if (entrada > menor && entrada < maior) {
  // return true;
  // } else {
  // return false;
  // }
  // }

}
