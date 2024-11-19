import Agendamento.subs.Visita; 
import Agendamento.subs.Vistoria;
import Imovel.subs.Casa;
import Usuario.subs.Comprador;
import Usuario.subs.Vendedor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TesteAgendamento {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        // Criar um comprador e um vendedor
        Comprador comprador = new Comprador("Comprador Teste", "comprador@example.com", "senha123");
        Vendedor vendedor = new Vendedor("Vendedor Teste", "vendedor@example.com", "senha123");

        // Criar um imóvel (Casa) para teste
        Casa casa = new Casa("Belo Horizonte", "Centro", "Rua A", 100, 120, 2000, 500, 350000, 2020, 3, 2, true, true, true, true, true);

        // Exibir dados do imóvel
        System.out.println("Imóvel disponível:");
        System.out.println("ID: " + casa.getId() + " - " + casa.getLocalizacao());

        // Menu Interativo
        boolean continuar = true;
        while (continuar) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Agendar Visita");
            System.out.println("2 - Agendar Vistoria");
            System.out.println("3 - Avaliar Imóvel");
            System.out.println("4 - Avaliar Vendedor");
            System.out.println("5 - Avaliar Cliente");
            System.out.println("6 - Sair");
            System.out.print("Opção: ");
            int escolha = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer do scanner
            

            switch (escolha) {
                case 1:
                    // Agendar visita
                    System.out.print("Digite o ID do imóvel que deseja visitar (ex: " + casa.getId() + "): ");
                    int idImovelVisita = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer

                    // Solicitar data para a visita
                    System.out.print("Digite a data da visita (Formato: YYYY-MM-DD): ");
                    String dataVisitaStr = scanner.nextLine();
                    System.out.print("Digite o horário da visita (Formato: HH:mm): ");
                    String horaVisitaStr = scanner.nextLine();

                    // Criar o SimpleDateFormat para a data e hora combinados
                    

                    try {
                        // Combinar a data e o horário em um único string e convertê-lo para Date
                        String dataHoraStr = dataVisitaStr + " " + horaVisitaStr;

                        // Verificar se a string gerada está no formato correto
                        System.out.println("Tentando converter a string: " + dataHoraStr); // Verificação

                        Date dataVisita = sdf.parse(dataHoraStr);  // Tentar converter a string para Date
                        System.out.println("Visita agendada para: " + dataVisita);

                        // Agendar visita com a data e imóvel
                        Visita visita = new Visita(idImovelVisita, dataVisita);
                        visita.agendarVisitaComValidade(casa, comprador, dataVisita);
                    } catch (Exception e) {
                        System.out.println("Erro ao agendar visita. Certifique-se de usar o formato correto de data e hora.");
                        e.printStackTrace(); // Exibir a stack trace do erro
                    }
                    break;

                case 2:
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

                case 3:
                    // Avaliar imóvel
                    System.out.print("Digite o ID do imóvel que deseja avaliar (ex: " + casa.getId() + "): ");
                    int idImovelAvaliar = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer

                    // Solicitar a nota para avaliação
                    System.out.print("Digite a nota para o imóvel (0 a 5): ");
                    double notaImovel = scanner.nextDouble();

                    // Avaliar o imóvel
                    casa.avaliarImovel(notaImovel);
                    break;

                case 4:
                    // Avaliar vendedor
                    System.out.print("Digite o ID do vendedor que deseja avaliar (ex: " + vendedor.getId() + "): ");
                    int idVendedorAvaliar = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer

                    // Solicitar a nota para avaliação
                    System.out.print("Digite a nota para o vendedor (0 a 5): ");
                    double notaVendedor = scanner.nextDouble();

                    // Avaliar o vendedor
                    vendedor.adicionarAvaliacao(notaVendedor);
                    break;

                case 5:
                    // Avaliar cliente
                    System.out.print("Digite o ID do cliente que deseja avaliar (ex: " + comprador.getId() + "): ");
                    int idClienteAvaliar = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer

                    // Solicitar a nota para avaliação
                    System.out.print("Digite a nota para o cliente (0 a 5): ");
                    double notaCliente = scanner.nextDouble();

                    // Avaliar o cliente
                    comprador.adicionarAvaliacao(notaCliente);
                    break;

                case 6:
                    // Sair
                    System.out.println("Saindo...");
                    continuar = false;
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}