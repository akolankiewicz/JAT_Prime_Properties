package Imovel.subs;

import Imovel.Imovel;

public class Pavilhao extends Imovel {
  private double capacidadeCarga;
  private double alturaTeto;
  private boolean areaManobra;

  public Pavilhao(String cidade, String bairro, String localizacao, double tamanho, double area,
      double valorAluguel, double condominio, double valorCompra, int anoConstrucao,
      int qtdQuartos, int qtdBanheiros, boolean mobiliado, double capacidadeCarga,
      double alturaTeto, boolean areaManobra) {
    super(cidade, bairro, localizacao, tamanho, area, valorAluguel, condominio, valorCompra,
        anoConstrucao, qtdQuartos, qtdBanheiros, mobiliado);
    this.capacidadeCarga = capacidadeCarga;
    this.alturaTeto = alturaTeto;
    this.areaManobra = areaManobra;
  }

  @Override
  public void getDadosImovel() {
    super.getDadosImovel();
    System.out.printf("Capacidade de Carga: %.2f toneladas\n", getCapacidadeCarga());
    System.out.printf("Altura do Teto: %.2f metros\n", getAlturaTeto());
    System.out.printf("Área de Manobra: %s\n", isAreaManobra() ? "Sim" : "Não");
  }

  public double getCapacidadeCarga() {
    return capacidadeCarga;
  }

  public void setCapacidadeCarga(double capacidadeCarga) {
    this.capacidadeCarga = capacidadeCarga;
  }

  public double getAlturaTeto() {
    return alturaTeto;
  }

  public void setAlturaTeto(double alturaTeto) {
    this.alturaTeto = alturaTeto;
  }

  public boolean isAreaManobra() {
    return areaManobra;
  }

  public void setAreaManobra(boolean areaManobra) {
    this.areaManobra = areaManobra;
  }
}
