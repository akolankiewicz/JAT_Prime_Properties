package Usuario.subs;

import Usuario.Usuario;

public class Cliente extends Usuario {
  private String status;
  private int Condicao;

  public Cliente(int id, String nome, String email, int nivelAcesso, String status, int Condicao) {
    super.setId(id);
    super.setNome(nome);
    super.setEmail(email);
    super.setNivelAcesso(nivelAcesso);
    this.setStatus(status);
    this.setCondicao(Condicao);
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public int getCondicao() {
    return Condicao;
  }

  public void setCondicao(int condicao) {
    Condicao = condicao;
  }
}
