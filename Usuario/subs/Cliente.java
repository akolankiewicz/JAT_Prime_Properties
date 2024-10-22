package Usuario.subs; // Pacote da classe Cliente

import Usuario.Usuario; // Importa a classe pai Usuario

/**
 * Classe Cliente que herda de Usuario.
 */
public class Cliente extends Usuario {
  private String status; // Status do cliente
  private int condicao; // Condição do cliente
  private String historico; // Histórico do cliente

  /**
   * Construtor da classe Cliente.
   */
  public Cliente(int id, String nome, String email, int nivelAcesso, String status, int condicao, String historico) {
    super.setId(id); // Define o ID do cliente
    super.setNome(nome); // Define o nome do cliente
    super.setEmail(email); // Define o email do cliente
    super.setNivelAcesso(nivelAcesso); // Define o nível de acesso
    this.setStatus(status); // Define o status
    this.setCondicao(condicao); // Define a condição
    this.setHistorico(historico); // Define o histórico
  }

  // Getters e Setters

  public String getStatus() {
    return status; // Retorna o status
  }

  public void setStatus(String status) {
    this.status = status; // Define o status
  }

  public int getCondicao() {
    return condicao; // Retorna a condição
  }

  public void setCondicao(int condicao) {
    this.condicao = condicao; // Define a condição
  }

  public String getHistorico() {
    return historico; // Retorna o histórico
  }

  public void setHistorico(String historico) {
    this.historico = historico; // Define o histórico
  }
}
