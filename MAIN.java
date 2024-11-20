import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import Imovel.*;
import Imovel.subs.Casa;
import Usuario.*;
import Usuario.subs.Administrador;
import Usuario.subs.Comprador;
import Usuario.subs.Vendedor;
import Agendamento.subs.Visita;
import Agendamento.subs.Vistoria;
import Agendamento.Agendamento;

public class MAIN {
  public static void main(String[] args) {
    // Paramêtros Globais (Objetos que representam usuário logado)
    Scanner scanner = new Scanner(System.in);
    Usuario usuarioAtual = null;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    Casa casa = new Casa("Belo Horizonte", "Centro", "Rua A", 100, 120, 2000, 500, 350000, 2020, 3, 2, true, true, true,
        true, true);
    Comprador comprador = new Comprador("Comprador Teste", "comprador@example.com", "senha123");
    Vendedor vendedor = new Vendedor("Vendedor Teste", "vendedor@example.com", "senha123");
    Imovel.getListaImoveis().add(casa);

    // Seção de login/cadastro
    int login_feito = 0;
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
          System.out.println("6. Avaliar cliente");
          System.out.println("7. Editar Usuário");
          System.out.println("8. Deletar Usuário");
          System.out.println("0. Sair");
          System.out.print("Escolha uma opção: ");
          opcao = scanner.nextInt();
          scanner.nextLine();

          // Validar a opção
          if (!verificaEntrada(1, 8, opcao)) {
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
            scanner.nextLine(); // Limpa o buffer após a leitura de um número
            
            System.out.print("Digite a data da vistoria (Formato: YYYY-MM-DD): ");
            String dataVistoriaStr = scanner.nextLine();
            
            System.out.print("Digite o horário da vistoria (Formato: HH:mm): ");
            String horaVistoriaStr = scanner.nextLine();
            
            try {
                String dataHoraVistoriaStr = dataVistoriaStr + " " + horaVistoriaStr;
                Date dataVistoria = sdf.parse(dataHoraVistoriaStr);
            
                // Agendar a vistoria
                Vistoria vistoria = new Vistoria(idImovelVistoria, dataVistoria);
                vistoria.agendarVistoria(idImovelVistoria, dataVistoria);
                System.out.println("Vistoria agendada com sucesso para " + dataVistoria);
            } catch (Exception e) {
                System.out.println("Erro ao agendar vistoria. Certifique-se de usar o formato correto de data e hora.");
                e.printStackTrace();
            }
                    continue;
              case 6:
                    // Avaliar cliente
                    System.out.print("Digite o ID do cliente que deseja avaliar (ex: " + comprador.getId() + "): ");
                    int idClienteAvaliar = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer

                    // Solicitar a nota para avaliação
                    System.out.print("Digite a nota para o cliente (0 a 5): ");
                    double notaCliente = scanner.nextDouble();

                    // Avaliar o cliente
                    comprador.adicionarAvaliacao(notaCliente);
                    continue;

            case 7:
              Usuario.editarUsuario(usuarioAtual, scanner);
              continue;

            case 8:
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
          System.out.println("4. Avaliar imovel");
          System.out.println("5. Avaliar vendedor");
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
          if (opcao < 0 || opcao > 8) {
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
            continue; // Volta ao menu do cliente

            case 5:
                    // Avaliar imóvel
                    System.out.print("Digite o ID do imóvel que deseja avaliar (ex: " + casa.getId() + "): ");
                    int idImovelAvaliar = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer

                    // Solicitar a nota para avaliação
                    System.out.print("Digite a nota para o imóvel (0 a 5): ");
                    double notaImovel = scanner.nextDouble();

                    // Avaliar o imóvel
                    casa.avaliarImovel(notaImovel);
                    continue;

            case 6:
                    // Avaliar vendedor
                    System.out.print("Digite o ID do vendedor que deseja avaliar (ex: " + vendedor.getId() + "): ");
                    int idVendedorAvaliar = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer

                    // Solicitar a nota para avaliação
                    System.out.print("Digite a nota para o vendedor (0 a 5): ");
                    double notaVendedor = scanner.nextDouble();

                    // Avaliar o vendedor
                    vendedor.adicionarAvaliacao(notaVendedor);
                    continue;

            case 7:
              Usuario.editarUsuario(usuarioAtual, scanner);
              continue;

            case 8:
              Usuario.deletarUsuario(usuarioAtual, scanner);
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

    scanner.close();
  }

  // Função auxiliar para verificar se a opção está dentro do intervalo esperado
  public static boolean verificaEntrada(int min, int max, int opcao) {
    return opcao >= min && opcao <= max || opcao == 0;
  }
}
