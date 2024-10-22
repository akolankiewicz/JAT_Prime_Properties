import Imovel.subs.Apartamento;
import Imovel.subs.Casa;
import Imovel.subs.Comercial;
import Imovel.subs.Pavilhao;
import java.util.Scanner; // Importação da classe Scanner para ler entradas do usuário

public class Programa {
  public static void main(String[] args) {
    int login_feito = 0; // Variável para verificar se o login ou cadastro foi realizado
    int opcao = 0; // Variável para armazenar a escolha do usuário no menu de ações

    Scanner scanner = new Scanner(System.in); // Criação do objeto Scanner para leitura de entradas

    // Menu de Login e Cadastro
    while (login_feito == 0) {
      System.out.println("Menu:");
      System.out.println("1. Login");
      System.out.println("2. Cadastro");
      System.out.print("Escolha uma opção: ");
      login_feito = scanner.nextInt(); // Lê a opção escolhida pelo usuário

      // Validação da opção escolhida
      if (login_feito != 1 && login_feito != 2) {
        System.out.println("Opção inválida. Por favor, escolha novamente."); // Mensagem de erro
        login_feito = 0; // Reinicia o valor para permitir nova tentativa
      }
    }

    // Menu de Ações
    while (opcao == 0) {
      System.out.println("Menu de Ações:");
      System.out.println("1. Alugar");
      System.out.println("2. Comprar");
      System.out.println("3. Visitar");
      System.out.print("Escolha uma opção: ");
      opcao = scanner.nextInt(); // Lê a opção escolhida pelo usuário

      // Validação da opção escolhida
      if (opcao < 1 || opcao > 3) {
        System.out.println("Opção inválida. Por favor, escolha novamente."); // Mensagem de erro
        opcao = 0; // Reinicia o valor para permitir nova tentativa
      }
    }

    // Criação dos imóveis
    Casa minhaCasa = new Casa(
        "Belo Horizonte", "Savassi", "Rua da Esperança, 45", 120.0, 110.0,
        3500.00, 0.00, 900000.00, 2018, 3, 2, true,
        true, true, true);

    System.out.println("Dados da Casa:");
    minhaCasa.getDadosImovel(); // Exibe os dados da casa
    System.out.println();

    Apartamento meuApartamento = new Apartamento(
        "Belo Horizonte", "Funcionários", "Avenida Getúlio Vargas, 123", 80.0, 75.0,
        2200.00, 800.00, 500000.00, 2020, 2, 1, true,
        5, 502, 2, true);

    System.out.println("Dados do Apartamento:");
    meuApartamento.getDadosImovel(); // Exibe os dados do apartamento
    System.out.println();

    Pavilhao meuPavilhao = new Pavilhao(
        "Belo Horizonte", "Nova Suíça", "Rua das Flores, 456", 300.0, 280.0,
        5000.00, 0.00, 1500000.00, 2015,
        0, 12, true, 150.0, 80, true);

    System.out.println("Dados do Pavilhão:");
    meuPavilhao.getDadosImovel(); // Exibe os dados do pavilhão
    System.out.println();

    Comercial minhaLoja = new Comercial(
        "Belo Horizonte", "Centro", "Praça Sete, 1", 150.0, 140.0,
        3500.00, 0.00, 800000.00, 2019,
        2, 0, false, 0, false, "Loja de Roupas");

    System.out.println("Dados do Imóvel Comercial:");
    minhaLoja.getDadosImovel(); // Exibe os dados do imóvel comercial

    scanner.close();
  }
}
