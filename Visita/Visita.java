package Visita;

import Imovel.Imovel;
import Usuario.Usuario;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Visita {
    private Imovel imovel;
    private Usuario cliente;
    private Date dataHora;
    
    // Lista para armazenar visitas agendadas
    private static List<Visita> visitasAgendadas = new ArrayList<>();

    public Visita(Imovel imovel, Usuario cliente, Date dataHora) {
        this.imovel = imovel;
        this.cliente = cliente;
        this.dataHora = dataHora;

        // Verifica se já existe uma visita agendada para o mesmo imóvel
        if (isHorarioDisponivel(imovel.getId(), dataHora)) {
            visitasAgendadas.add(this);
        } else {
            throw new IllegalArgumentException("Horário já agendado para este imóvel.");
        }
    }

    private boolean isHorarioDisponivel(int idImovel, Date dataHora) {
        for (Visita visita : visitasAgendadas) {
            if (visita.imovel.getId() == idImovel && visita.dataHora.equals(dataHora)) {
                return false; // Conflito de horário
            }
        }
        return true; // Horário disponível
    }

    // Métodos getters
    public Imovel getImovel() {
        return imovel;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public Date getDataHora() {
        return dataHora;
    }
}