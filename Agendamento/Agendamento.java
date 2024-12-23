package Agendamento;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Agendamento.subs.Visita;
import Agendamento.subs.Vistoria;

public class Agendamento implements InterfaceAgendamento {

    private static List<Agendamento> listaAgendamentos = new ArrayList<>();

    private int idImovel;
    private Date dataVisita;

    public Agendamento(int idImovel, Date dataVisita) {
        this.idImovel = idImovel;
        this.dataVisita = dataVisita;
    }

    @Override
    public boolean verificarDisponibilidade(int idImovel, Date dataVisita) {
        for (Agendamento agendamento : listaAgendamentos) {
            if (agendamento.idImovel == idImovel && agendamento.dataVisita.equals(dataVisita)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void agendarVisita(int idImovel, Date dataVisita) {
        if (verificarDisponibilidade(idImovel, dataVisita)) {
            Agendamento novoAgendamento = new Visita(idImovel, dataVisita);
            listaAgendamentos.add(novoAgendamento);
            System.out.println("Visita agendada com sucesso!");
        } else {
            System.out.println("Erro: Já existe uma visita agendada para esse horário.");
        }
    }

    @Override
    public void agendarVistoria(int idImovel, Date dataVisita) {
        Agendamento novoAgendamento = new Vistoria(idImovel, dataVisita);
        listaAgendamentos.add(novoAgendamento);
        System.out.println("Vistoria agendada com sucesso!");
    }

    public int getIdImovel() {
        return idImovel;
    }

    public Date getDataVisita() {
        return dataVisita;
    }

    public void agendarVistoriaComValidade(int idImovel, Date dataVisita) {
        Date dataAtual = new Date();
        if (dataVisita.before(dataAtual)) {
            System.out.println("Erro: Não é possível agendar uma vistoria para uma data anterior ao dia de hoje.");
            return;
        }

        boolean disponivel = verificarDisponibilidade(idImovel, dataVisita);
        if (!disponivel) {
            System.out.println("Erro: Já existe uma vistoria agendada para esse imóvel nesse horário.");
            return;
        }

        listaAgendamentos.add(this);
        System.out.println("Vistoria agendada com sucesso para o imóvel ID: " + idImovel + " na data: " + dataVisita);
    }
}
