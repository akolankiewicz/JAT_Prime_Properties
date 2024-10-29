import Imovel.*;
import Imovel.subs.*;

import java.lang.reflect.Array;
import java.util.Objects;

public class ImovelTest {
  public static void main(String[] args) {
    Comercial imov = new Comercial("Chapecó", null, null, 0, 0, 0, 0, 0, 0, 0, 1900, false, 0, true, null);
    Casa imov1 = new Casa(null, null, null, 0, 0, 0, 0, 0, 0, 0, 1900, false, false, true, true);
    Apartamento imov2 = new Apartamento("Chapecó", null, null, 0, 0, 0, 0, 0, 0, 0, 1900, false, 1, 1, 1, true);
    Pavilhao imov3 = new Pavilhao(null, null, null, 0, 0, 0, 0, 0, 0, 0, 1900, false, 0, 0, true);

    // teste de Auto Increment no ID por metodo static
    System.out.printf("\n\n%d%, d%, d%, d\n\n", imov.getId(), imov1.getId(), imov2.getId(), imov3.getId());

    imov.addImovel(imov);
    imov.addImovel(imov1);
    imov.addImovel(imov2);
    imov.addImovel(imov3);

    Object[] filtros = { "Chapecó", null, null, null, null, null, null, null, null, null, 1900, null, null, null };
    imov.filtrarImoveis(filtros);

  }
}
