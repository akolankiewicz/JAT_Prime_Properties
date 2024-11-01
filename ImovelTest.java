import Imovel.*;
import Imovel.subs.*;

public class ImovelTest {
  public static void main(String[] args) {
    Comercial comercial = new Comercial("Chapecó", null, null, 0, 0, 0, 0, 0, 0, 0, 1900, false, 0, true, null);
    Casa casa = new Casa(null, null, null, 0, 0, 0, 0, 0, 0, 0, 1900, false, false, true, true);
    Apartamento apartamento = new Apartamento("Chapecó", null, null, 0, 0, 0, 0, 0, 0, 0, 1900, false, 1, 1, 1, true);
    Pavilhao pavilhao = new Pavilhao(null, null, null, 0, 0, 0, 0, 0, 0, 0, 1900, false, 0, 0, true);

    // teste de Auto Increment no ID por metodo static, cada imovel id unico para
    // facilitar, id == codigo do imovel
    System.out.printf("\n\n%d%, d%, d%, d\n\n", comercial.getId(), casa.getId(), apartamento.getId(), pavilhao.getId());

    Imovel.addImovel(comercial);
    Imovel.addImovel(casa);
    Imovel.addImovel(apartamento);
    Imovel.addImovel(pavilhao);

    Object[] filtros = { "Chapecó", null, null, null, null, null, null, null, null, null, 1900, null, null, null };
    Imovel.filtrarImoveis(filtros);

  }
}
