package Agendamento.subs;

import java.util.Date;

import Agendamento.Agendamento;
import Imovel.Imovel;

public class Vistoria extends Agendamento {

    public Vistoria(int idImovel, Date dataVisita) {
        super(idImovel, dataVisita);
    }

    @Override
    public void agendarVistoria(int idImovel, Date dataVisita) {
        super.agendarVistoria(idImovel, dataVisita);
    }

    public boolean verificarDisponibilidadeVistoria(Imovel imovel, Date dataVistoria) {
        if (!imovel.getDisponivel()) {
            System.out.println("O imóvel não está disponível para vistoria.");
            return false;
        }
        if (dataVistoria.before(new Date())) {
            System.out.println("A data da visitoria já passou.");
            return false;
        }
        return true;
    }
}