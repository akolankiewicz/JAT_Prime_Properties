package Usuario.subs;

import Imovel.Imovel;
import Usuario.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Comprador extends Cliente {
    private List<Imovel> imoveisAlugados;
    List<Usuario> usuarios = Usuario.getListaUsuarios();
    List<Imovel> listaImoveis = Imovel.getListaImoveis();

    public Comprador(String nome, String email, String senha) {
        super(nome, email, senha);
        this.imoveisAlugados = new ArrayList<>();
    }

    public void alugarImovel(int idImovel) {
        if (usuarios == null || listaImoveis == null) {
            System.out.println("Erro: Lista de usuários ou de imóveis inválida.");
            return;
        }

        Imovel imovelAlugado = null;

        for (Imovel imovel : listaImoveis) {
            if (imovel.getId() == idImovel) {
                imovelAlugado = imovel;
                break;
            }
        }

        if (imovelAlugado == null) {
            System.out.println("Erro: Imóvel com ID " + idImovel + " não encontrado.");
            return;
        }

        if (imovelAlugado.getDisponivel() == false) {
            System.out.println("Imóvel Indisponível!");
            return;
        }

        for (Usuario usuario : usuarios) {
            if (usuario instanceof Vendedor && usuario.getId() == imovelAlugado.getIdDono()) {
                imovelAlugado.setDisponivel(false);
                Vendedor vendedor = (Vendedor) usuario;
                imoveisAlugados.add(imovelAlugado);
                vendedor.deletarImovel(imovelAlugado);
                System.out.println("Imóvel alugado com sucesso: " + imovelAlugado.getId());
                return;
            }
        }

        System.out.println("Erro: Vendedor do imóvel não encontrado.");
    }

    public void comprarImovel(int idImovel) {
        if (usuarios == null || listaImoveis == null) {
            System.out.println("Erro: Lista de usuários ou de imóveis inválida.");
            return;
        }

        Imovel imovelComprado = null;

        for (Imovel imovel : listaImoveis) {
            if (imovel.getId() == idImovel) {
                imovelComprado = imovel;
                break;
            }
        }

        if (imovelComprado == null) {
            System.out.println("Erro: Imóvel com ID " + idImovel + " não encontrado.");
            return;
        }

        if (imovelComprado.getDisponivel() == false) {
            System.out.println("Imóvel Indisponível!");
            return;
        }

        for (Usuario usuario : usuarios) {
            if (usuario instanceof Vendedor && usuario.getId() == imovelComprado.getIdDono()) {
                Vendedor vendedor = (Vendedor) usuario;
                vendedor.deletarImovel(imovelComprado);
                System.out.println("Imóvel comprado com sucesso: " + imovelComprado.getId());
                return;
            }
        }

        System.out.println("Erro: Vendedor do imóvel não encontrado.");
    }

    public boolean respostaSimOuNao() {
        throw new UnsupportedOperationException("Unimplemented method 'respostaSimOuNao'");
    }

    public double obterNota() {
        throw new UnsupportedOperationException("Unimplemented method 'obterNota'");
    }
}
