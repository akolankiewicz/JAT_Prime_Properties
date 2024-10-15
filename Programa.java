import Imovel.subs.Apartamento;
import Imovel.subs.Casa;
import Imovel.subs.Comercial;
import Imovel.subs.Pavilhao;

public class Programa {
  public static void main(String[] args) {
    Casa minhaCasa = new Casa(
        "Belo Horizonte", "Savassi", "Rua da Esperança, 45", 120.0, 110.0,
        3500.00, 0.00, 900000.00, 2018, 3, 2, true,
        true, true, true);

    System.out.println("Dados da Casa:");
    minhaCasa.getDadosImovel();
    System.out.println();

    Apartamento meuApartamento = new Apartamento(
        "Belo Horizonte", "Funcionários", "Avenida Getúlio Vargas, 123", 80.0, 75.0,
        2200.00, 800.00, 500000.00, 2020, 2, 1, true,
        5, 502, 2, true);

    System.out.println("Dados do Apartamento:");
    meuApartamento.getDadosImovel();
    System.out.println();

    Pavilhao meuPavilhao = new Pavilhao(
        "Belo Horizonte", "Nova Suíça", "Rua das Flores, 456", 300.0, 280.0,
        5000.00, 0.00, 1500000.00, 2015,
        0, 12, true, 150.0, 80, true);

    System.out.println("Dados do Pavilhão:");
    meuPavilhao.getDadosImovel();
    System.out.println();

    Comercial minhaLoja = new Comercial(
        "Belo Horizonte", "Centro", "Praça Sete, 1", 150.0, 140.0,
        3500.00, 0.00, 800000.00, 2019,
        2, 0, false, 0, false, "Loja de Roupas");

    System.out.println("Dados do Imóvel Comercial:");
    minhaLoja.getDadosImovel();
  }
}
