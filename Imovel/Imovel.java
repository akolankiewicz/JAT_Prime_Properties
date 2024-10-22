package Imovel;

public class Imovel {
  private String cidade;
  private String bairro;
  private String localizacao;
  private double tamanho;
  private double area;
  private double valorAluguel;
  private double condominio;
  private double valorCompra;
  private double notaAvaliacao;
  private int anoConstrucao;
  private int qtdQuartos;
  private int qtdBanheiros;
  private boolean mobiliado;

  public Imovel(String cidade, String bairro, String localizacao, double tamanho, double area,
      double valorAluguel, double condominio, double valorCompra, int anoConstrucao,
      int qtdQuartos, int qtdBanheiros, boolean mobiliado) {
    this.cidade = cidade;
    this.bairro = bairro;
    this.localizacao = localizacao;
    this.tamanho = tamanho;
    this.area = area;
    this.valorAluguel = valorAluguel;
    this.condominio = condominio;
    this.valorCompra = valorCompra;
    this.anoConstrucao = anoConstrucao;
    this.qtdQuartos = qtdQuartos;
    this.qtdBanheiros = qtdBanheiros;
    this.mobiliado = mobiliado;
  }

  public void getDadosImovel() {
    System.out.printf("Cidade: %s\n", getCidade());
    System.out.printf("Bairro: %s\n", getBairro());
    System.out.printf("Localização: %s\n", getLocalizacao());
    System.out.printf("Tamanho: %.2f m²\n", getTamanho());
    System.out.printf("Área: %.2f m²\n", getArea());
    System.out.printf("Valor do Aluguel: R$ %.2f\n", getValorAluguel());
    System.out.printf("Condomínio: R$ %.2f\n", getCondominio());
    System.out.printf("Valor de Compra: R$ %.2f\n", getValorCompra());
    System.out.printf("Ano de Construção: %d\n", getAnoConstrucao());
    System.out.printf("Quantidade de Quartos: %d\n", getQtdQuartos());
    System.out.printf("Quantidade de Banheiros: %d\n", getQtdBanheiros());
    System.out.printf("Mobiliado: %s\n", getMobiliado() ? "Sim" : "Não");
  }

  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public String getBairro() {
    return bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public String getLocalizacao() {
    return localizacao;
  }

  public void setLocalizacao(String localizacao) {
    this.localizacao = localizacao;
  }

  public double getTamanho() {
    return tamanho;
  }

  public void setTamanho(double tamanho) {
    this.tamanho = tamanho;
  }

  public double getArea() {
    return area;
  }

  public void setArea(double area) {
    this.area = area;
  }

  public double getValorAluguel() {
    return valorAluguel;
  }

  public void setValorAluguel(double valorAluguel) {
    this.valorAluguel = valorAluguel;
  }

  public double getCondominio() {
    return condominio;
  }

  public void setCondominio(double condominio) {
    this.condominio = condominio;
  }

  public double getValorCompra() {
    return valorCompra;
  }

  public void setValorCompra(double valorCompra) {
    this.valorCompra = valorCompra;
  }

  public int getAnoConstrucao() {
    return anoConstrucao;
  }

  public void setAnoConstrucao(int anoConstrucao) {
    this.anoConstrucao = anoConstrucao;
  }

  public int getQtdQuartos() {
    return qtdQuartos;
  }

  public void setQtdQuartos(int qtdQuartos) {
    this.qtdQuartos = qtdQuartos;
  }

  public int getQtdBanheiros() {
    return qtdBanheiros;
  }

  public void setQtdBanheiros(int qtdBanheiros) {
    this.qtdBanheiros = qtdBanheiros;
  }

  public boolean getMobiliado() {
    return mobiliado;
  }

  public void setMobiliado(boolean mobiliado) {
    this.mobiliado = mobiliado;
  }

  public void setNotaAvaliacao(double nota, int numeroAvaliacoes) {
    double media = nota / numeroAvaliacoes;
    if (media < 1) {
      System.out.println("Ops, alguma avaliação foi lançada errada, verifica ai ADM!\n");
      return;
    }
    this.notaAvaliacao = media;
  }

  public double getNotaAvaliacao() {
    return this.notaAvaliacao;
  }
}
