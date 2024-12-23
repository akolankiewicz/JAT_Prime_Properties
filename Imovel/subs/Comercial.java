package Imovel.subs;

import Imovel.Imovel;

public class Comercial extends Imovel {
  private int numeroSalas;
  private boolean espacoEstacionamento;
  private String tipoComercio;

  public Comercial(int idDono, String cidade, String bairro, String localizacao, double tamanho, double area,
      double valorAluguel, double condominio, double valorCompra, int anoConstrucao,
      int qtdQuartos, int qtdBanheiros, boolean mobiliado, boolean disponibilidade, int numeroSalas,
      boolean espacoEstacionamento, String tipoComercio) {
    super(idDono, cidade, bairro, localizacao, tamanho, area, valorAluguel, condominio, valorCompra, anoConstrucao,
        qtdQuartos,
        qtdBanheiros, mobiliado, disponibilidade);
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
    System.out.println("Imóvel: Sala Comercial\n");
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
