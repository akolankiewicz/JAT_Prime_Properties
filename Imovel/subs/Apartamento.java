package Imovel.subs;

import Imovel.Imovel;

public class Apartamento extends Imovel {
  private int andar;
  private int numeroApartamento;
  private int vagaGaragem;
  private boolean sacada;

  public Apartamento(String cidade, String bairro, String localizacao, double tamanho, double area,
      double valorAluguel, double condominio, double valorCompra, int anoConstrucao,
      int qtdQuartos, int qtdBanheiros, boolean mobiliado, boolean disponibilidade, int andar,
      int numeroApartamento, int vagaGaragem, boolean sacada) {
    super(vagaGaragem, vagaGaragem, cidade, bairro, localizacao, tamanho, area, valorAluguel, condominio, valorCompra,
        anoConstrucao, qtdQuartos, qtdBanheiros, vagaGaragem, mobiliado, disponibilidade);
    this.andar = andar;
    this.numeroApartamento = numeroApartamento;
    this.vagaGaragem = vagaGaragem;
    this.sacada = sacada;
  }

  @Override
  public void getDadosImovel() {
    super.getDadosImovel();
    System.out.printf("Andar: %d\n", getAndar());
    System.out.printf("Número do Apartamento: %d\n", getNumeroApartamento());
    System.out.printf("Vaga de Garagem: %s\n", isVagaGaragem());
    System.out.printf("Sacada: %s\n", isSacada() ? "Sim" : "Não");
    System.out.println("Imóvel: Apartamento\n");
  }

  public int getAndar() {
    return andar;
  }

  public void setAndar(int andar) {
    this.andar = andar;
  }

  public int getNumeroApartamento() {
    return numeroApartamento;
  }

  public void setNumeroApartamento(int numeroApartamento) {
    this.numeroApartamento = numeroApartamento;
  }

  public int isVagaGaragem() {
    return vagaGaragem;
  }

  public void setVagaGaragem(int vagaGaragem) {
    this.vagaGaragem = vagaGaragem;
  }

  public boolean isSacada() {
    return sacada;
  }

  public void setSacada(boolean sacada) {
    this.sacada = sacada;
  }
}
