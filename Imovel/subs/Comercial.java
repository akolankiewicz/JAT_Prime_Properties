package Imovel.subs;

import Imovel.Imovel;

public class Comercial extends Imovel {
  private int numeroSalas;
  private boolean espacoEstacionamento;
  private String tipoComercio;

  public Comercial(String cidade, String bairro, String localizacao, double tamanho, double area,
      double valorAluguel, double condominio, double valorCompra, int anoConstrucao,
      int qtdQuartos, int qtdBanheiros, boolean mobiliado, int numeroSalas,
      boolean espacoEstacionamento, String tipoComercio) {
    super(numeroSalas, cidade, bairro, localizacao, tamanho, area, valorAluguel, condominio, valorCompra,
        anoConstrucao, qtdQuartos, qtdBanheiros, numeroSalas, mobiliado, espacoEstacionamento);
    this.numeroSalas = numeroSalas;
    this.espacoEstacionamento = espacoEstacionamento;
    this.tipoComercio = tipoComercio;
  }

  @Override
  public void getDadosImovel() {
    super.getDadosImovel();
    System.out.printf("Número de Salas: %d\n", getNumeroSalas());
    System.out.printf("Estacionamento: %s\n", isEspacoEstacionamento() ? "Sim" : "Não");
    System.out.printf("Tipo de Comércio: %s\n", getTipoComercio());
  }

  public int getNumeroSalas() {
    return numeroSalas;
  }

  public void setNumeroSalas(int numeroSalas) {
    this.numeroSalas = numeroSalas;
  }

  public boolean isEspacoEstacionamento() {
    return espacoEstacionamento;
  }

  public void setEspacoEstacionamento(boolean espacoEstacionamento) {
    this.espacoEstacionamento = espacoEstacionamento;
  }

  public String getTipoComercio() {
    return tipoComercio;
  }

  public void setTipoComercio(String tipoComercio) {
    this.tipoComercio = tipoComercio;
  }
}
