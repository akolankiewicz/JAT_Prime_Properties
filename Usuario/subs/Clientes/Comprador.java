package Usuario.subs.Clientes; 
import Imovel.Imovel; 
import Usuario.subs.Cliente;
import java.util.ArrayList;
import java.util.List;

public class Comprador extends Cliente {
    private List<Imovel> imoveisAlugados; // Lista de imóveis alugados

    public Comprador(String nome, String email, String senha) {
        super(nome, email, senha);
        
        this.imoveisAlugados = new ArrayList<>(); // Inicializa a lista de imóveis alugados
    }

    // Método para alugar um imóvel
    public void alugarImovel(Vendedor vendedor, List<Imovel> todosImoveis, int idImovel) {
        if (vendedor == null || todosImoveis == null) {
            System.out.println("Erro: Vendedor ou lista de imóveis inválidos.");
            return;
        }
    
        for (Imovel imovel : todosImoveis) {
            if (imovel.getId() == idImovel) {
                // Adiciona o imóvel à lista de alugados
                imoveisAlugados.add(imovel);
                // Deleta o imóvel do vendedor
                vendedor.deletarImovel(imovel);
                System.out.println("Imóvel alugado com sucesso: " + imovel.getId());
                return; // Finaliza o método após alugar o imóvel
            }
        }
        System.out.println("Erro: Imóvel com ID " + idImovel + " não encontrado.");
    }
    
    public void comprarImovel(Vendedor vendedor, List<Imovel> todosImoveis, int idImovel) {
        if (vendedor == null || todosImoveis == null) {
            System.out.println("Erro: Vendedor ou lista de imóveis inválidos.");
            return;
        }
    
        for (Imovel imovel : todosImoveis) {
            if (imovel.getId() == idImovel) {
                // Deleta o imóvel do vendedor
                vendedor.deletarImovel(imovel);
                System.out.println("Imóvel comprado com sucesso: " + imovel.getId());
                return; // Finaliza o método após comprar o imóvel
            }
        }
        System.out.println("Erro: Imóvel com ID " + idImovel + " não encontrado.");
    }

    // Método para listar imóveis alugados
    public void listarImoveisAlugados() {
        if (imoveisAlugados.isEmpty()) {
            System.out.println("Nenhum imóvel alugado.");
            return;
        }
        System.out.println("Imóveis Alugados:");
        for (Imovel imovel : imoveisAlugados) {
            System.out.println("ID: " + imovel.getId() + " - Descrição: " + imovel.getId());
        }
    }
}
