package Usuario.subs; 
import Usuario.Usuario; 
public class Comprador extends Usuario {
  public Comprador(String nome, String email, String senha) {
      super(nome, email, senha, "comprador");
  }
}