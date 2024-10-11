package Usuario.subs;

import Usuario.Usuario;

public class Adm extends Usuario {
  private String funcaoEmpresa;

  public Adm(int id, String nome, String email, int nivelAcesso, String funcaoEmpresa) {
    super.setId(id);
    super.setNome(nome);
    super.setEmail(email);
    super.setNivelAcesso(nivelAcesso);
    this.setFuncaoEmpresa(funcaoEmpresa);
  }

  public String getFuncaoEmpresa() {
    return funcaoEmpresa;
  }

  public void setFuncaoEmpresa(String funcaoEmpresa) {
    this.funcaoEmpresa = funcaoEmpresa;
  }
}
