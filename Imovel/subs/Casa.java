package Imovel.subs;

import Imovel.Imovel;

public class Casa extends Imovel {
  private boolean garagem;
  private boolean quintal;
  private boolean piscina;

  public Casa(String cidade, String bairro, String localizacao, double tamanho, double area,
      double valorAluguel, double condominio, double valorCompra, int anoConstrucao,
      int qtdQuartos, int qtdBanheiros, boolean mobiliado, boolean disponibilidade, boolean piscina,
      boolean garagem, boolean quintal) {
    super(qtdBanheiros, qtdBanheiros, cidade, bairro, localizacao, tamanho, area, valorAluguel, condominio, valorCompra,
        anoConstrucao, qtdQuartos, qtdBanheiros, qtdBanheiros, mobiliado, disponibilidade);
    this.piscina = piscina;
    this.garagem = garagem;
    this.quintal = quintal;
  }

  


  @Override
  public void getDadosImovel() {
    super.getDadosImovel();
    System.out.printf("Garagem: %s\n", getGaragem() ? "Sim" : "Não");
    System.out.printf("Quintal: %s\n", getQuintal() ? "Sim" : "Não");
    System.out.printf("Piscina: %s\n", getPiscina() ? "Sim" : "Não");
    System.out.println("Imóvel: Casa\n");
  }

  public boolean getGaragem() {
    return garagem;
  }

  public void setGaragem(boolean garagem) {
    this.garagem = garagem;
  }

  public boolean getQuintal() {
    return quintal;
  }

  public void setQuintal(boolean quintal) {
    this.quintal = quintal;
  }

  public boolean getPiscina() {
    return piscina;
  }

  public void setPiscina(boolean piscina) {
    this.piscina = piscina;
  }
}
