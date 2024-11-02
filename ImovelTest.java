import Imovel.*;
import Imovel.subs.*;

public class ImovelTest {
    public static void main(String[] args) {
        // Casas
        Casa casa1 = new Casa("Florianópolis", "Centro", "Rua A", 310, 330, 2500, 300, 1000000, 2009, 3, 2, true, false,
                true,
                true);
        Casa casa2 = new Casa("Blumenau", "Velha", "Rua B", 4, 3, 150, 2, 120, 250, 550, 2015, true, true, true, false);
        Casa casa3 = new Casa("Joinville", "Bom Retiro", "Rua C", 2, 1, 90, 0, 80, 150, 300, 2005, false, false, false,
                true);
        Casa casa4 = new Casa("Chapecó", "Efapi", "Rua D", 5, 4, 180, 2, 130, 280, 600, 2020, true, true, true, true);
        Casa casa5 = new Casa("Itajaí", "Cordeiros", "Rua E", 3, 2, 110, 1, 90, 210, 450, 2018, false, true, true,
                false);

        // Apartamentos
        Apartamento apartamento1 = new Apartamento("Chapecó", "Centro", "Rua F", 2, 1, 60, 5, 80, 90, 200, 2019, true,
                1, 1,
                1, true);
        Apartamento apartamento2 = new Apartamento("São José", "Kobrasol", "Rua G", 3, 2, 80, 10, 100, 120, 300, 2021,
                true,
                2, 2, 1, true);
        Apartamento apartamento3 = new Apartamento("Criciúma", "Próspera", "Rua H", 1, 1, 45, 2, 60, 70, 150, 2010,
                false,
                0, 1, 0, false);
        Apartamento apartamento4 = new Apartamento("Balneário Camboriú", "Barra Sul", "Rua I", 4, 3, 130, 15, 150, 180,
                500,
                2022, true, 3, 3, 2, true);
        Apartamento apartamento5 = new Apartamento("Lages", "Coral", "Rua J", 2, 1, 70, 3, 85, 95, 220, 2018, false, 1,
                1,
                1, true);

        // Comerciais
        Comercial comercial1 = new Comercial("Chapecó", "Centro", "Rua K", 100, 50, 0, 0, 300, 350, 2000, 2015, false,
                0,
                true, "Escritório");
        Comercial comercial2 = new Comercial("Florianópolis", "Trindade", "Rua L", 200, 100, 0, 1, 400, 450, 600, 2017,
                true, 0, false, "Loja");
        Comercial comercial3 = new Comercial("Joinville", "Centro", "Rua M", 150, 70, 0, 2, 350, 400, 500, 2019, true,
                1,
                true, "Restaurante");
        Comercial comercial4 = new Comercial("Blumenau", "Itoupava", "Rua N", 120, 60, 0, 1, 320, 370, 550, 2021, false,
                0,
                false, "Clínica");

        // Pavilhões
        Pavilhao pavilhao1 = new Pavilhao("Chapecó", "Industrial", "Rua O", 500, 250, 0, 0, 1000, 1200, 5000, 2016,
                true, 2,
                1, true);
        Pavilhao pavilhao2 = new Pavilhao("Itajaí", "Centro", "Rua P", 600, 300, 0, 0, 1100, 1300, 5500, 2019, true, 3,
                2,
                false);

        Imovel.addImovel(casa1);
        Imovel.addImovel(casa2);
        Imovel.addImovel(casa3);
        Imovel.addImovel(casa4);
        Imovel.addImovel(casa5);
        Imovel.addImovel(apartamento1);
        Imovel.addImovel(apartamento2);
        Imovel.addImovel(apartamento3);
        Imovel.addImovel(apartamento4);
        Imovel.addImovel(apartamento5);
        Imovel.addImovel(comercial1);
        Imovel.addImovel(comercial2);
        Imovel.addImovel(comercial3);
        Imovel.addImovel(comercial4);
        Imovel.addImovel(pavilhao1);
        Imovel.addImovel(pavilhao2);

        casa1.avaliarImovel(4);
        casa1.avaliarImovel(4);
        casa1.avaliarImovel(5);
        casa1.avaliarImovel(3);
        casa1.avaliarImovel(2);

        casa1.getDadosImovel();
        // Imoveis de teste acima;

        // Object[] filtros = { null, null, null, null, null, null, null, null, null,
        // null, null, null, null, null };
        // Imovel.filtrarImoveis(filtros);
    }
}
