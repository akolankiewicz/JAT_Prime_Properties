package Usuario;

import java.util.*;

public class Usuario {
  private int id;              // Identificador único do usuário
  private String nome;         // Nome do usuário
  private String email;        // E-mail do usuário
  private int nivelAcesso;     // Nível de acesso do usuário
  private int idade;           // Idade do usuário
  private String cpf;          // CPF do usuário

  /**
   * Método para realizar o login do usuário.
   *
   * @param logEmail E-mail que o usuário está tentando usar para login.
   * @param Emails Lista de e-mails cadastrados.
   * @param idade Idade do usuário.
   * @return Um Optional contendo o usuário se o login for bem-sucedido, ou vazio se falhar.
   */

  /**
   * FUTUROS AJUSTES
   * O método está criando um novo objeto Usuario toda vez que o login é bem-sucedido. 
   * Em vez disso, você poderia retornar a instância atual do usuário, se ele já existir. 
   * Caso contrário, o usuário deve ser criado durante o cadastro. */ 

  public Optional<Usuario> login(String logEmail, List<String> Emails, int idade) {
    for (String email : Emails) {
      // Verifica se o e-mail fornecido corresponde a um e-mail cadastrado
      if (email.equals(logEmail)) { 
        // Verifica se a idade do usuário é maior ou igual a 18 anos
        if (idade < 18) {
          return Optional.empty(); // Retorna vazio se a idade for menor que 18
        }
        // Cria um novo usuário e configura o e-mail
        Usuario usu = new Usuario();
        usu.setEmail(logEmail);
        return Optional.of(usu); // Retorna o usuário em um Optional
      }
    }
    return Optional.empty(); // Retorna vazio se o e-mail não for encontrado
  }

  /**
   * Método para cadastrar um novo usuário.
   *
   * @param newEmail E-mail do novo usuário.
   * @param nome Nome do novo usuário.
   * @param cpf CPF do novo usuário.
   * @param Emails Lista de e-mails cadastrados.
   * @return Uma mensagem indicando o resultado do cadastro.
   */
  public String cadastrar(String newEmail, String nome, String cpf, List<String> Emails) {
    // Verifica se o nome foi preenchido
    if (nome == null || nome.isEmpty()) {
      return "Nome deve ser preenchido!\n"; 
    }
    // Verifica se o e-mail foi preenchido
    if (newEmail == null || newEmail.isEmpty()) {
      return "E-mail deve ser preenchido!\n"; 
    }
    // Verifica se o CPF foi preenchido
    if (cpf == null || cpf.isEmpty()) {
      return "CPF deve ser preenchido!\n"; 
    }
    // Verifica se o e-mail já existe na lista
    for (String email : Emails) {
      if (email.equals(newEmail)) { 
        return "E-mail já existente! Cadastre-se ou entre em sua conta.\n";
      }
    }
    // Adiciona o novo e-mail à lista de e-mails cadastrados
    Emails.add(newEmail);
    return "Cadastro Realizado com Sucesso!\n"; // Retorna sucesso
  }

  // GETTERS E SETTERS

  public int getId() {
    return id; // Retorna o ID do usuário
  }

  public void setId(int id) {
    this.id = id; // Define o ID do usuário
  }

  public String getNome() {
    return nome; // Retorna o nome do usuário
  }

  public void setNome(String nome) {
    this.nome = nome; // Define o nome do usuário
  }

  public String getEmail() {
    return email; // Retorna o e-mail do usuário
  }

  public void setEmail(String email) {
    this.email = email; // Define o e-mail do usuário
  }

  public int getNivelAcesso() {
    return nivelAcesso; // Retorna o nível de acesso do usuário
  }

  public void setNivelAcesso(int nivelAcesso) {
    this.nivelAcesso = nivelAcesso; // Define o nível de acesso do usuário
  }

  public int getIdade() {
    return idade; // Retorna a idade do usuário
  }

  public void setIdade(int idade) {
    this.idade = idade; // Define a idade do usuário
  }

  public String getCpf() {
    return cpf; // Retorna o CPF do usuário
  }

  public void setCpf(String cpf) {
    this.cpf = cpf; // Define o CPF do usuário
  }
}