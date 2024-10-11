package Usuario;

import java.util.*;

public class Usuario {
  private int id;
  private String nome;
  private String email;
  private int nivelAcesso;

  public Optional<Usuario> login(String logEmail, List<String> Emails) {
    for (String email : Emails) {
      if (email == logEmail) {
        Usuario usu = new Usuario();
        return Optional.ofNullable(usu);
      }
    }
    return Optional.ofNullable(null);
  }

  public void logout() {

  }

  public String cadastrar(String newEmail, List<String> Emails) {
    for (String email : Emails) {
      if (email == newEmail) {
        return "E-mail já existente! cadastre-se ou entre em sua conta.\n";
      }
    }
    Emails.add(newEmail);
    return "Cadastro Realizado com Sucesso!\n";
  }

  // GETTERS E SETTERS
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getNivelAcesso() {
    return nivelAcesso;
  }

  public void setNivelAcesso(int nivelAcesso) {
    this.nivelAcesso = nivelAcesso;
  }
}
