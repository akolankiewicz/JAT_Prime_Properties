import Imovel.Imovel;
import Usuario.Usuario;
import Visita.Visita;
import Visita.Avaliacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class VisitaEAvaliacao {
    private Scanner scanner;
    private Usuario usuarioAtual;
    
    public VisitaEAvaliacao(Usuario usuarioAtual) {
        this.scanner = new Scanner(System.in);
        this.usuarioAtual = usuarioAtual;
    }

    public void agendarVisita(List<Imovel> imoveis) {
        System.out.print("Digite o ID do imóvel que deseja visitar: ");
        int idImovel = scanner.nextInt();
        Imovel imovel = findImovelById(imoveis, idImovel);
        
        if (imovel != null) {
            System.out.print("Digite a data e hora da visita (Formato: YYYY-MM-DD HH:MM): ");
            String dataHoraStr = scanner.next();

            try {
                Date dataHora = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(dataHoraStr);
                Visita visita = new Visita(imovel, usuarioAtual, dataHora); // Criar o objeto de visita
                System.out.println("Visita agendada com sucesso!");
            } catch (ParseException e) {
                System.out.println("Erro ao formatar a data e hora.");
            }
        } else {
            System.out.println("Imóvel não encontrado!");
        }
    }

    public void avaliarImovel(Imovel imovel) {
        System.out.print("Digite a nota para o imóvel (0 a 5): ");
        double notaImovel = scanner.nextDouble();

        System.out.print("Digite a nota para o vendedor (0 a 5): ");
        double notaVendedor = scanner.nextDouble();

        Avaliacao avaliacao = new Avaliacao(imovel, usuarioAtual, notaImovel, notaVendedor);
        System.out.println("Avaliação registrada com sucesso!");
    }

    private Imovel findImovelById(List<Imovel> imoveis, int id) {
        for (Imovel imovel : imoveis) {
            if (imovel.getId() == id) {
                return imovel;
            }
        }
        return null; // Imóvel não encontrado
    }
}