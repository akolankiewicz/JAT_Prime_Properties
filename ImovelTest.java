import Imovel.*;

import java.lang.reflect.Array;
import java.util.Objects;

public class ImovelTest {
  public static void main(String[] args) {
    Imovel imov = new Imovel(1, 0, "Chapecó", null, null, 0, 0, 0, 0, 0, 0, 0, 1900, 0, false, false);
    Imovel imov1 = new Imovel(2, 0, null, null, null, 0, 0, 0, 0, 0, 0, 0, 1900, 0, false, false);
    Imovel imov2 = new Imovel(3, 0, null, null, null, 0, 0, 0, 0, 0, 0, 0, 1900, 0, false, false);
    Imovel imov3 = new Imovel(4, 0, null, null, null, 0, 0, 0, 0, 0, 0, 0, 1900, 0, false, false);
    imov.addImovel(imov);
    imov.addImovel(imov1);
    imov.addImovel(imov2);
    imov.addImovel(imov3);

    Object[] filtros = { "Chapecó", null, null, null, null, null, null, null, null, null, 1900, null, null, null };
    imov.filtrarImoveis(filtros);

  }
}
