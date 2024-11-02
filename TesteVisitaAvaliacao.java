import Imovel.Imovel;
import Imovel.subs.Apartamento;
import Imovel.subs.Casa;
import Imovel.subs.Comercial;
import Imovel.subs.Pavilhao;
import Usuario.Usuario;
import Usuario.subs.Comprador;
import Usuario.subs.Vendedor;
import Visita.Avaliacao;
import Visita.Visita;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class TesteVisitaAvaliacao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criar usuários (comprador e vendedor)
        Vendedor vendedor = new Vendedor("Vendedor1", "vendedor@example.com", "senha123");
        Comprador comprador = new Comprador("Comprador1", "comprador@example.com", "senha123");

        // Criar imóveis
        Casa casa = new Casa("Belo Horizonte", "Savassi", "Rua da Esperança, 45", 120.0, 110.0,
                3500.00, 0.00, 900000.00, 2018, 3, 2, true, true, true, true);
        Apartamento apartamento = new Apartamento("Belo Horizonte", "Funcionários", "Avenida Getúlio Vargas, 123", 
                80.0, 75.0, 2200.00, 800.00, 500000.00, 2020, 2, 1, true, 5, 502, 2, true);
        
        // Adicionar imóveis a uma lista
        List<Imovel> imoveis = new ArrayList<>();
        imoveis.add(casa);
        imoveis.add(apartamento);

        // Testar agendamento de visita
        agendarVisita(comprador, imoveis, scanner);
        
        // Testar avaliação de imóvel
        avaliarImovel(comprador, imoveis, scanner);

        scanner.close();
    }

    private static void agendarVisita(Comprador comprador, List<Imovel> imoveis, Scanner scanner) {
        System.out.println("\n=== Teste de Agendamento de Visita ===");
        
        // Exibir a lista de imóveis disponíveis
        System.out.println("Escolha um imóvel para visitar:");
        for (Imovel imovel : imoveis) {
            System.out.printf("ID: %d - %s, Localização: %s\n", imovel.getId(), imovel.getCidade(), imovel.getLocalizacao());
        }

        // Solicitar ao usuário que digite o ID do imóvel
        System.out.print("Digite o ID do imóvel que deseja visitar: ");
        int idImovel = scanner.nextInt();
        
        // Verifica se o ID está dentro do intervalo da lista de imóveis
        if (idImovel < 1 || idImovel > imoveis.size()) {
            System.out.println("ID do imóvel inválido! Tente novamente.");
            return;
        }

        Imovel imovelEscolhido = findImovelById(imoveis, idImovel);
        
        if (imovelEscolhido != null) {
            // Solicitar a data da visita
            System.out.print("Digite a data da visita (Formato: YYYY-MM-DD): ");
            String dataStr = scanner.next(); // Lê apenas a data
            
            try {
                // Usar o formato apenas para data, sem hora
                Date dataVisita = new SimpleDateFormat("yyyy-MM-dd", new Locale("pt", "BR")).parse(dataStr);
                // Criar a visita sem a parte da hora
                Visita visita = new Visita(imovelEscolhido, comprador, dataVisita);
                System.out.println("Visita agendada com sucesso para o imóvel: " + imovelEscolhido.getId());
            } catch (ParseException e) {
                System.out.println("Erro ao agendar visita: " + e.getMessage());
            }
        } else {
            System.out.println("Imóvel não encontrado!");
        }
    }

    private static void avaliarImovel(Comprador comprador, List<Imovel> imoveis, Scanner scanner) {
        System.out.println("\n=== Teste de Avaliação de Imóvel ===");
        
        // Exibir a lista de imóveis disponíveis para avaliação
        System.out.println("Escolha um imóvel para avaliar:");
        for (Imovel imovel : imoveis) {
            System.out.printf("ID: %d - %s, Localização: %s\n", imovel.getId(), imovel.getCidade(), imovel.getLocalizacao());
        }

        // Solicitar ao usuário que digite o ID do imóvel
        System.out.print("Digite o ID do imóvel que deseja avaliar: ");
        int idImovel = scanner.nextInt();

        // Verifica se o ID está dentro do intervalo da lista de imóveis
        if (idImovel < 1 || idImovel > imoveis.size()) {
            System.out.println("ID do imóvel inválido! Tente novamente.");
            return;
        }

        Imovel imovelEscolhido = findImovelById(imoveis, idImovel);

        if (imovelEscolhido != null) {
            // Solicitar nota para o imóvel
            System.out.print("Digite a nota para o imóvel (0 a 5): ");
            double notaImovel = scanner.nextDouble();
            System.out.print("Digite a nota para o vendedor (0 a 5): ");
            double notaVendedor = scanner.nextDouble();

            Avaliacao avaliacao = new Avaliacao(imovelEscolhido, comprador, notaImovel, notaVendedor);
            System.out.println("Avaliação registrada com sucesso!");
            avaliacao.exibirAvaliacoes(); // Exibe as avaliações
        } else {
            System.out.println("Imóvel não encontrado!");
        }
    }

    private static Imovel findImovelById(List<Imovel> imoveis, int id) {
        for (Imovel imovel : imoveis) {
            if (imovel.getId() == id) {
                return imovel; // Retorna o imóvel se o ID corresponder
            }
        }
        return null; // Retorna null se o imóvel não for encontrado
    }
}