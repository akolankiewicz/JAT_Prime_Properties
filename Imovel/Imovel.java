package Imovel;

import java.lang.reflect.Array;
import java.util.Objects;

public class Imovel implements AbsImovel {
  private int id;
  private int idDono;
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
  private boolean disponivel;
  private Imovel[] arrayImoveis;

  public Imovel(int idDono, String cidade, String bairro, String localizacao, double tamanho, double area,
      double valorAluguel, double condominio, double valorCompra, double notaAvaliacao, int anoConstrucao,
      int qtdQuartos, int qtdBanheiros, boolean mobiliado, boolean disp) {
    this.setIdDono(idDono);
    this.setCidade(cidade);
    this.setBairro(bairro);
    this.setLocalizacao(localizacao);
    this.setTamanho(tamanho);
    this.setArea(area);
    this.setValorAluguel(valorAluguel);
    this.setCondominio(condominio);
    this.setValorCompra(valorCompra);
    this.setAnoConstrucao(anoConstrucao);
    this.setQtdQuartos(qtdQuartos);
    this.setQtdBanheiros(qtdBanheiros);
    this.setMobiliado(mobiliado);
    this.setDisponivel(disp);
  }

  @Override
  public void getDadosImovel() {
    System.out.printf("Id: %d", getId());
    System.out.printf("Cidade: %s\n", getCidade());
    System.out.printf("Bairro: %s\n", getBairro());
    System.out.printf("Localização: %s\n", getLocalizacao());
    System.out.printf("Tamanho: %.2f m²\n", getTamanho());
    System.out.printf("Área: %.2f m²\n", getArea());
    System.out.printf("Valor do Aluguel: R$ %.2f\n", getValorAluguel());
    System.out.printf("Condomínio: R$ %.2f\n", getCondominio());
    System.out.printf("Valor de Compra: R$ %.2f\n", getValorCompra());
    System.out.printf("Avaliação: %.1f estrelas\n", getNotaAvaliacao());
    System.out.printf("Ano de Construção: %d\n", getAnoConstrucao());
    System.out.printf("Quantidade de Quartos: %d\n", getQtdQuartos());
    System.out.printf("Quantidade de Banheiros: %d\n", getQtdBanheiros());
    System.out.printf("Mobiliado: %s\n", getMobiliado() ? "Sim" : "Não");
    System.out.printf("Este imovel está alugado?", getDisponivel() ? "Sim" : "Não");
  }

  public void editDadosImovel(int idImovelEdicao, int id, String cidade, String bairro, String localizacao,
      double tamanho, double area,
      double valorAluguel, double condominio, double valorCompra, double notaAvaliacao, int anoConstrucao,
      int qtdQuartos, int qtdBanheiros, boolean mobiliado, boolean disp) {
    for (Imovel imovel : this.arrayImoveis) {
      if (imovel.id == idImovelEdicao) {
        // manipular dados da edição
      }
    }
  }

  public void filtrarImoveis(Imovel[] arrayImoveis, Array filtros[]) {
    String[] variaveis = {
        "cidade",
        "bairro",
        "localizacao",
        "tamanho",
        "area",
        "valorAluguel",
        "condominio",
        "valorCompra",
        "notaAvaliacao",
        "anoConstrucao",
        "qtdQuartos",
        "qtdBanheiros",
        "mobiliado"
    };

    for (Imovel imovel : arrayImoveis) {
      boolean match = true;

      // Verifica cidade
      if (filtros[0] != null && !Objects.equals(filtros[0], imovel.getCidade())) {
        match = false;
      }

      // Verifica bairro
      if (filtros[1] != null && !Objects.equals(filtros[1], imovel.getBairro())) {
        match = false;
      }

      // Verifica localização
      if (filtros[2] != null && !Objects.equals(filtros[2], imovel.getLocalizacao())) {
        match = false;
      }

      // Verifica tamanho
      if (filtros[3] != null && !Objects.equals(filtros[3], imovel.getTamanho())) {
        match = false;
      }

      // Verifica área
      if (filtros[4] != null && Double.compare(Double.parseDouble(filtros[4]), imovel.getArea()) != 0) {
        match = false;
      }

      // Verifica valor de aluguel
      if (filtros[5] != null && Double.compare(Double.parseDouble(filtros[5]), imovel.getValorAluguel()) != 0) {
        match = false;
      }

      // Verifica condomínio
      if (filtros[6] != null && Double.compare(Double.parseDouble(filtros[6]), imovel.getCondominio()) != 0) {
        match = false;
      }

      // Verifica valor de compra
      if (filtros[7] != null && Double.compare(Double.parseDouble(filtros[7]), imovel.getValorCompra()) != 0) {
        match = false;
      }

      // Verifica nota de avaliação
      if (filtros[8] != null && Double.compare(Double.parseDouble(filtros[8]), imovel.getNotaAvaliacao()) != 0) {
        match = false;
      }

      // Verifica ano de construção
      if (filtros[9] != null && Integer.compare(Integer.parseInt(filtros[9]), imovel.getAnoConstrucao()) != 0) {
        match = false;
      }

      // Verifica quantidade de quartos
      if (filtros[10] != null && Integer.compare(Integer.parseInt(filtros[10]), imovel.getQtdQuartos()) != 0) {
        match = false;
      }

      // Verifica quantidade de banheiros
      if (filtros[11] != null && Integer.compare(Integer.parseInt(filtros[11]), imovel.getQtdBanheiros()) != 0) {
        match = false;
      }

      // Verifica se é mobiliado
      if (filtros[12] != null && Boolean.compare(Boolean.parseBoolean(filtros[12]), imovel.isMobiliado()) != 0) {
        match = false;
      }

      // Se todos os filtros passarem
      if (match) {
        System.out.println("Imóvel corresponde aos filtros: " + imovel.getId());
      }
    }
  }

  public void setIdDono(int idDono) {
    this.idDono = idDono;
  }

  public int getIdDono() {
    return this.idDono;
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
    if (tamanho < 0) {
      System.out.println("Tamanho negativo não existe. Tente novamente");
      return;
    }
    this.tamanho = tamanho;
  }

  public double getArea() {
    return area;
  }

  public void setArea(double area) {
    if (area < 0) {
      System.out.println("Área negativa não existe. Tente novamente");
      return;
    }
    this.area = area;
  }

  public double getValorAluguel() {
    return valorAluguel;
  }

  public void setValorAluguel(double valorAluguel) {
    if (valorAluguel < 0) {
      System.out.println("Alugel negativo não existe. Tente novamente");
      return;
    }
    this.valorAluguel = valorAluguel;
  }

  public double getCondominio() {
    return condominio;
  }

  public void setCondominio(double condominio) {
    if (condominio < 0) {
      System.out.println("Condominio negativo não existe. Tente novamente");
      return;
    }
    this.condominio = condominio;
  }

  public double getValorCompra() {
    return valorCompra;
  }

  public void setValorCompra(double valorCompra) {
    if (valorCompra < 0) {
      System.out.println("Se for pra vender de graça vende pra mim! Tente novamente.");
    }
    this.valorCompra = valorCompra;
  }

  public int getAnoConstrucao() {
    return anoConstrucao;
  }

  public void setAnoConstrucao(int anoConstrucao) {
    if (anoConstrucao < 0) {
      System.out.println("Ano negativo não existe. Tente novamente");
    }
    this.anoConstrucao = anoConstrucao;
  }

  public int getQtdQuartos() {
    return qtdQuartos;
  }

  public void setQtdQuartos(int qtdQuartos) {
    if (qtdQuartos < 0) {
      System.out.println("Quantidade de quartos negativa não existe. Tente novamente");
      return;
    }
    this.qtdQuartos = qtdQuartos;
  }

  public int getQtdBanheiros() {
    return qtdBanheiros;
  }

  public void setQtdBanheiros(int qtdBanheiros) {
    if (tamanho < 0) {
      System.out.println("Quantidade de banheiros negativa não existe. Tente novamente");
      return;
    }

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

  public boolean getDisponivel() {
    return this.disponivel;
  }

  public void setDisponivel(boolean disp) {
    this.disponivel = disp;
  }

  public int getId() {
    return this.id;
  }
}
