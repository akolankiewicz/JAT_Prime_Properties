package Agendamento.subs;

import Agendamento.Agendamento;
import Imovel.Imovel;
import Usuario.subs.Comprador;
import Usuario.subs.Vendedor;
import java.util.Date;

public class Visita extends Agendamento {

    public Visita(int idImovel, Date dataVisita) {
        super(idImovel, dataVisita);
    }

    public boolean verificarDisponibilidadeVisita(Imovel imovel, Date dataVisita) {
        if (!imovel.getDisponivel()) {
            System.out.println("O imóvel não está disponível para visita.");
            return false;
        }
        if (dataVisita.before(new Date())) {
            System.out.println("A data da visita já passou.");
            return false;
        }
        return true;
    }

    public void agendarVisitaComValidade(Imovel imovel, Comprador comprador, Date dataVisita) {
        if (verificarDisponibilidadeVisita(imovel, dataVisita)) {
            super.agendarVisita(imovel.getId(), dataVisita);
            System.out.println(
                    "Visita agendada com sucesso para o imóvel ID: " + imovel.getId() + " na data " + dataVisita);

            if (dataVisita.before(new Date())) {
                System.out.print("Avaliar o imóvel? (Sim/Não): ");
                if (comprador.respostaSimOuNao()) {
                    System.out.print("Digite sua nota para o imóvel (0 a 5): ");
                    double notaImovel = comprador.obterNota();
                    imovel.avaliarImovel(notaImovel);
                }

                System.out.print("Avaliar o vendedor? (Sim/Não): ");
                if (comprador.respostaSimOuNao()) {
                    System.out.print("Digite sua nota para o vendedor (0 a 5): ");
                    double notaVendedor = comprador.obterNota();
                    Vendedor vendedor = new Vendedor("Vendedor Teste", "vendedor@example.com", "senha123");
                    vendedor.avaliarVendedor(notaVendedor);
                    vendedor.avaliarVendedor(notaVendedor);
                }
            }
        }
    }
}