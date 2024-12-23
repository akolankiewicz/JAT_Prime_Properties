package Imovel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import Imovel.subs.*;

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
  private static List<Imovel> listaImoveis = new ArrayList<>();
  private static List<Imovel> listaImoveisFiltrados = new ArrayList<>();
  private static int cont = 0;
  private int qtdAvaliacoes = 0;
  Scanner sc = new Scanner(System.in);

  public Imovel(int idDono, String cidade, String bairro, String localizacao, double tamanho, double area,
      double valorAluguel, double condominio, double valorCompra, int anoConstrucao,
      int qtdQuartos, int qtdBanheiros, boolean mobiliado, boolean disp) {
    this.id = ++cont;
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
    System.out.printf("Código de Imóvel: %d\n", getId());
    System.out.printf("Vendedor ID: %d\n", getId());
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
    System.out.printf("Disponível: %s\n", getDisponivel() ? "Sim" : "Não");
  }

  public static void addImovelFiltrado(Imovel imovel) {
    Imovel.listaImoveisFiltrados.add(imovel);
  }

  public void avaliarImovel(double nota, int idRecebedorNota) {
    for (Imovel imovel : Imovel.listaImoveis) {
      if (imovel.id == idRecebedorNota) {
        imovel.qtdAvaliacoes++;
        if (qtdAvaliacoes == 1) {
          imovel.setNotaAvaliacao(nota);
          System.out.printf("Média do imóvel %d atualizada, resultando em uma nota de %.1f estrelas!", imovel.getId(),
              imovel.getNotaAvaliacao());
          return;
        }
        double somaAtual = this.getNotaAvaliacao() * (imovel.qtdAvaliacoes - 1);
        double novaMedia = (somaAtual + nota) / imovel.qtdAvaliacoes;
        imovel.setNotaAvaliacao(novaMedia);
        System.out.printf("Média do imóvel %d atualizada, resultando em uma nota de %.1f estrelas!", imovel.getId(),
            imovel.getNotaAvaliacao());
        return;
      }
    }
  }

  public static void addImovel(Imovel imovel) {
    Imovel.listaImoveis.add(imovel);
  }

  public static void removerImovel(int idImovelRemocao) {
    try {
      for (Imovel imovel : listaImoveis) {
        if (imovel.getId() == idImovelRemocao) {
          Imovel.listaImoveis.remove(idImovelRemocao);
          System.out.printf("Imóvel %d (Dono: ID %d) removido com sucesso!\n", idImovelRemocao, imovel.getIdDono());
          return;
        }
      }
    } catch (Exception IndexOutOfBoundsException) {
      System.out.println("Ops... o ID citado (" + idImovelRemocao + ") não pertence a nenhum imóvel!");
    }
  }

  public void avaliarImovel(double nota) {
    qtdAvaliacoes++; // Incrementa o número de avaliações
    for (Imovel imovel : Imovel.listaImoveis) {
      if (imovel.id == this.id) {
        if (qtdAvaliacoes == 1) {
          imovel.setNotaAvaliacao(nota);
          System.out.printf("Média do imóvel %d atualizada, resultando em uma nota de %.1f estrelas!\n", this.getId(),
              imovel.getNotaAvaliacao());
          return;
        }
        double somaAtual = this.getNotaAvaliacao() * (qtdAvaliacoes - 1);
        double novaMedia = (somaAtual + nota) / qtdAvaliacoes;
        imovel.setNotaAvaliacao(novaMedia);
        System.out.printf("Média do imóvel %d atualizada, resultando em uma nota de %.1f estrelas!\n", this.getId(),
            imovel.getNotaAvaliacao());
        return;
      }
    }
  }

  // avisando que scanner jamais sera fechado
  @SuppressWarnings("resource")
  public static void filtrarImoveis() {
    int contador = 0;
    Scanner sc = new Scanner(System.in);
    Object[] filtros = new Object[14];
    System.out.println("Preencha os filtros abaixo. Pressione ENTER para ignorar o filtro.");

    System.out.print("Cidade: ");
    String cidade = sc.nextLine();
    filtros[0] = cidade.isEmpty() ? null : cidade;

    System.out.print("Bairro: ");
    String bairro = sc.nextLine();
    filtros[1] = bairro.isEmpty() ? null : bairro;

    System.out.print("Localização: ");
    String localizacao = sc.nextLine();
    filtros[2] = localizacao.isEmpty() ? null : localizacao;

    System.out.print("Tamanho (m²): ");
    String tamanhoStr = sc.nextLine();
    filtros[3] = tamanhoStr.isEmpty() ? null : Double.valueOf(tamanhoStr);

    System.out.print("Área (m²): ");
    String areaStr = sc.nextLine();
    filtros[4] = areaStr.isEmpty() ? null : Double.valueOf(areaStr);

    System.out.print("Valor do aluguel: ");
    String valorAluguelStr = sc.nextLine();
    filtros[5] = valorAluguelStr.isEmpty() ? null : Double.valueOf(valorAluguelStr);

    System.out.print("Valor do condomínio: ");
    String condominioStr = sc.nextLine();
    filtros[6] = condominioStr.isEmpty() ? null : Double.valueOf(condominioStr);

    System.out.print("Valor de compra: ");
    String valorCompraStr = sc.nextLine();
    filtros[7] = valorCompraStr.isEmpty() ? null : Double.valueOf(valorCompraStr);

    System.out.print("Nota de avaliação: ");
    String notaStr = sc.nextLine();
    filtros[8] = notaStr.isEmpty() ? null : Double.valueOf(notaStr);

    System.out.print("Ano de construção: ");
    String anoConstrucaoStr = sc.nextLine();
    filtros[9] = anoConstrucaoStr.isEmpty() ? null : Integer.valueOf(anoConstrucaoStr);

    System.out.print("Quantidade de quartos: ");
    String qtdQuartosStr = sc.nextLine();
    filtros[10] = qtdQuartosStr.isEmpty() ? null : Integer.valueOf(qtdQuartosStr);

    System.out.print("Quantidade de banheiros: ");
    String qtdBanheirosStr = sc.nextLine();
    filtros[11] = qtdBanheirosStr.isEmpty() ? null : Integer.valueOf(qtdBanheirosStr);

    System.out.print("É mobiliado? (true/false): ");
    String mobiliadoStr = sc.nextLine();
    filtros[12] = mobiliadoStr.isEmpty() ? null : Boolean.valueOf(mobiliadoStr);

    System.out.print("Está disponível? (true/false): ");
    String disponivelStr = sc.nextLine();
    filtros[13] = disponivelStr.isEmpty() ? null : Boolean.valueOf(disponivelStr);

    for (Imovel imovel : Imovel.listaImoveis) {
      boolean match = true;

      if (filtros[0] != null && !Objects.equals(filtros[0], imovel.getCidade())) {
        match = false;
      }
      if (filtros[1] != null && !Objects.equals(filtros[1], imovel.getBairro())) {
        match = false;
      }
      if (filtros[2] != null && !Objects.equals(filtros[2], imovel.getLocalizacao())) {
        match = false;
      }
      if (filtros[3] != null && filtros[3] instanceof Double
          && !Objects.equals((Double) filtros[3], imovel.getTamanho())) {
        match = false;
      }
      if (filtros[4] != null && filtros[4] instanceof Double
          && !Objects.equals((Double) filtros[4], imovel.getArea())) {
        match = false;
      }
      if (filtros[5] != null && filtros[5] instanceof Double
          && !Objects.equals((Double) filtros[5], imovel.getValorAluguel())) {
        match = false;
      }
      if (filtros[6] != null && filtros[6] instanceof Double
          && !Objects.equals((Double) filtros[6], imovel.getCondominio())) {
        match = false;
      }
      if (filtros[7] != null && filtros[7] instanceof Double
          && !Objects.equals((Double) filtros[7], imovel.getValorCompra())) {
        match = false;
      }
      if (filtros[8] != null && filtros[8] instanceof Double
          && !Objects.equals((Double) filtros[8], imovel.getNotaAvaliacao())) {
        match = false;
      }
      if (filtros[9] != null && filtros[9] instanceof Integer
          && !Objects.equals((Integer) filtros[9], imovel.getAnoConstrucao())) {
        match = false;
      }
      if (filtros[10] != null && filtros[10] instanceof Integer
          && !Objects.equals((Integer) filtros[10], imovel.getQtdQuartos())) {
        match = false;
      }
      if (filtros[11] != null && filtros[11] instanceof Integer
          && !Objects.equals((Integer) filtros[11], imovel.getQtdBanheiros())) {
        match = false;
      }
      if (filtros[12] != null && filtros[12] instanceof Boolean
          && !Objects.equals((Boolean) filtros[12], imovel.getMobiliado())) {
        match = false;
      }
      if (filtros[13] != null && filtros[13] instanceof Boolean
          && !Objects.equals((Boolean) filtros[13], imovel.getDisponivel())) {
        match = false;
      }

      if (match) {
        contador++;
        Imovel.addImovelFiltrado(imovel);
      }
    }
    if (contador > 0) {
      System.out.printf(
          "\n%d imovéis correspondem á sua pesquisa, deseja visualizá-los? ( 1-Sim / 2-Não / 3 - Filtrar tipo específico )\n",
          contador);
      int acao = sc.nextInt();
      if (acao == 1) {
        for (Imovel imovel : Imovel.listaImoveisFiltrados) {
          Imovel.printDadosImovelComLayout(imovel);
        }
      } else if (acao == 3) {
        System.out.println("Deseja filtrar por algum tipo de Imóvel em específico?\n");
        System.out.println("1 - Apenas Casas\n");
        System.out.println("2 - Apenas Apartamentos\n");
        System.out.println("3 - Apenas Comerciais\n");
        System.out.println("4 - Apenas Barracão/Pavilhão\n");
        System.out.println("5 - Filtrar Todos\n");
        int option = sc.nextInt();
        int entrouFor = 0;
        switch (option) {
          case 1:
            for (Imovel imovel : Imovel.listaImoveisFiltrados) {
              if (imovel instanceof Casa) {
                Imovel.printDadosImovelComLayout(imovel);
                entrouFor = 1;
              }
            }
            if (entrouFor != 1) {
              System.out.println("Sentimos muito, sua pesquisa não retornou resultados.\n");
            }
            break;
          case 2:
            for (Imovel imovel : Imovel.listaImoveisFiltrados) {
              if (imovel instanceof Apartamento) {
                Imovel.printDadosImovelComLayout(imovel);
                entrouFor = 1;
              }
            }
            if (entrouFor != 1) {
              System.out.println("Sentimos muito, sua pesquisa não retornou resultados.\n");
            }
            break;
          case 3:
            for (Imovel imovel : Imovel.listaImoveisFiltrados) {
              if (imovel instanceof Comercial) {
                Imovel.printDadosImovelComLayout(imovel);
                entrouFor = 1;
              }
            }
            if (entrouFor != 1) {
              System.out.println("Sentimos muito, sua pesquisa não retornou resultados.\n");
            }
            break;
          case 4:
            for (Imovel imovel : Imovel.listaImoveisFiltrados) {
              if (imovel instanceof Pavilhao) {
                Imovel.printDadosImovelComLayout(imovel);
                entrouFor = 1;
              }
            }
            if (entrouFor != 1) {
              System.out.println("Sentimos muito, sua pesquisa não retornou resultados.\n");
            }
            break;
          case 5:
            for (Imovel imovel : Imovel.listaImoveisFiltrados) {
              Imovel.printDadosImovelComLayout(imovel);
              entrouFor = 1;
            }
            if (entrouFor != 1) {
              System.out.println("Sentimos muito, sua pesquisa não retornou resultados.\n");
            }
            break;
          default:
            System.out.println("Digite uma opção válida!\n");
            break;
        }
      }
    } else {
      System.out.println("Sentimos muito, sua pesquisa não retornou resultados.\n");
    }
  }

  public static void listarImoveis() {
    for (Imovel imovel : listaImoveis) {
      printDadosImovelComLayout(imovel);
    }
  }

  public static void printDadosImovelComLayout(Imovel imovel) {
    System.out.printf("================= Imóvel %d ===================\n", imovel.getId());
    imovel.getDadosImovel();
    System.out.println("----------------------------------------------\n\n");
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
    if (tamanho >= 0)
      this.tamanho = tamanho;
  }

  public double getArea() {
    return area;
  }

  public void setArea(double area) {
    if (area >= 0)
      this.area = area;
  }

  public double getValorAluguel() {
    return valorAluguel;
  }

  public void setValorAluguel(double valorAluguel) {
    if (valorAluguel >= 0)
      this.valorAluguel = valorAluguel;
  }

  public double getCondominio() {
    return condominio;
  }

  public void setCondominio(double condominio) {
    if (condominio >= 0)
      this.condominio = condominio;
  }

  public double getValorCompra() {
    return valorCompra;
  }

  public void setValorCompra(double valorCompra) {
    if (valorCompra >= 0)
      this.valorCompra = valorCompra;
  }

  public int getAnoConstrucao() {
    return anoConstrucao;
  }

  public void setAnoConstrucao(int anoConstrucao) {
    if (anoConstrucao >= 0)
      this.anoConstrucao = anoConstrucao;
  }

  public int getQtdQuartos() {
    return qtdQuartos;
  }

  public void setQtdQuartos(int qtdQuartos) {
    if (qtdQuartos >= 0)
      this.qtdQuartos = qtdQuartos;
  }

  public int getQtdBanheiros() {
    return qtdBanheiros;
  }

  public void setQtdBanheiros(int qtdBanheiros) {
    if (qtdBanheiros >= 0)
      this.qtdBanheiros = qtdBanheiros;
  }

  public boolean getMobiliado() {
    return mobiliado;
  }

  public void setMobiliado(boolean mobiliado) {
    this.mobiliado = mobiliado;
  }

  public void setNotaAvaliacao(double nota) {
    this.notaAvaliacao = nota;
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

  public static List<Imovel> getListaImoveis() {
    return listaImoveis; // Retorna a lista de imóveis
  }
}
