package Agendamento;

import java.util.Date;

public interface InterfaceAgendamento {
    boolean verificarDisponibilidade(int idImovel, Date dataVisita);
    void agendarVisita(int idImovel, Date dataVisita);
    void agendarVistoria(int idImovel, Date dataVisita);
}