package Visita;

import Imovel.Imovel;
import Usuario.Usuario;

public class Avaliacao {
    private Imovel imovel;
    private Usuario vendedor;
    private double notaImovel;
    private double notaVendedor;

    public Avaliacao(Imovel imovel, Usuario vendedor, double notaImovel, double notaVendedor) {
        this.imovel = imovel;
        this.vendedor = vendedor;
        this.notaImovel = notaImovel;
        this.notaVendedor = notaVendedor;
    }

    // Métodos para obter avaliações
    public Imovel getImovel() {
        return imovel;
    }

    public Usuario getVendedor() {
        return vendedor;
    }

    public double getNotaImovel() {
        return notaImovel;
    }

    public double getNotaVendedor() {
        return notaVendedor;
    }

    // Método para exibir as avaliações
    public void exibirAvaliacoes() {
        System.out.printf("Avaliação do Imóvel (ID: %d): %.1f\n", imovel.getId(), notaImovel);
        System.out.printf("Avaliação do Vendedor (ID: %d): %.1f\n", vendedor.getId(), notaVendedor);
    }
}