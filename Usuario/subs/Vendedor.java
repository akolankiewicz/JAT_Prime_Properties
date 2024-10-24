package Usuario.subs; 

import java.util.ArrayList;
import java.util.List;

import Imovel.Imovel;
import Usuario.Usuario; 
public class Vendedor extends Usuario {
    private List<Imovel> imoveis = new ArrayList<>();
    
    public Vendedor(String nome, String email, String senha) {
        super(nome, email, senha, "vendedor");
    }

    public void adicionarImovel(Imovel imovel) {
        imoveis.add(imovel);
        System.out.println("Imóvel adicionado: " + imovel);
    }

    public void listarImoveis() {
        if (imoveis.isEmpty()) {
            System.out.println("Nenhum imóvel cadastrado.");
            return;
        }
        System.out.println("Lista de Imóveis:");
        for (Imovel imovel : imoveis) {
            System.out.println(imovel);
        }
    }

    public boolean deletarImovel(Imovel imovel) {
        if (imoveis.remove(imovel)) {
            System.out.println("Imóvel removido: " + imovel);
            return true;
        } else {
            System.out.println("Imóvel não encontrado: " + imovel);
            return false;
        }
    }
  }