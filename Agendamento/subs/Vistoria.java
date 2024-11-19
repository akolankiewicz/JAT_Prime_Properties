package Agendamento.subs;

import java.util.Date;

import Agendamento.Agendamento;

public class Vistoria extends Agendamento {

    public Vistoria(int idImovel, Date dataVisita) {
        super(idImovel, dataVisita);
    }

    @Override
    public void agendarVistoria(int idImovel, Date dataVisita) {
        super.agendarVistoria(idImovel, dataVisita);
    }
}