package Usuario.subs;

import Imovel.Imovel;
import Imovel.subs.Apartamento;
import Imovel.subs.Casa;
import Imovel.subs.Comercial;
import Imovel.subs.Pavilhao;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Vendedor extends Cliente {
    private static Scanner sc = new Scanner(System.in);
    private static List<Imovel> todosImoveis = new ArrayList<>();
    public List<Imovel> imoveis = new ArrayList<>();

    public Vendedor(String nome, String email, String senha) {
        super(nome, email, senha);
    }

    public void adicionarImovel() {
        int valorEscolhido = 0;
        Imovel imovel = null;

        String cidade, bairro, localizacao;
        double tamanho, area, valorAluguel, condominio, valorCompra;
        int anoConstrucao, qtdQuartos, qtdBanheiros;
        boolean mobiliado;

        while (valorEscolhido == 0) {
            try {
                System.out.println("Selecione o imóvel que deseja adicionar: ");
                System.out.println("1 - APARTAMENTO");
                System.out.println("2 - CASA");
                System.out.println("3 - PAVILHÃO");
                System.out.println("4 - COMERCIAL");
                System.out.print("Digite o número da opção: ");

                valorEscolhido = sc.nextInt();

                System.out.print("Cidade: ");
                cidade = sc.next();
                System.out.print("Bairro: ");
                bairro = sc.next();
                System.out.print("Localização: ");
                localizacao = sc.next();
                System.out.print("Tamanho (m²): ");
                tamanho = sc.nextDouble();
                System.out.print("Área (m²): ");
                area = sc.nextDouble();
                System.out.print("Valor do Aluguel: ");
                valorAluguel = sc.nextDouble();
                System.out.print("Condomínio: ");
                condominio = sc.nextDouble();
                System.out.print("Valor de Compra: ");
                valorCompra = sc.nextDouble();
                System.out.print("Ano de Construção: ");
                anoConstrucao = sc.nextInt();
                System.out.print("Quantidade de Quartos: ");
                qtdQuartos = sc.nextInt();
                System.out.print("Quantidade de Banheiros: ");
                qtdBanheiros = sc.nextInt();
                System.out.print("Mobiliado (true/false): ");
                mobiliado = sc.nextBoolean();

                switch (valorEscolhido) {
                    case 1:
                        // Apartamento
                        System.out.print("Andar: ");
                        int andar = sc.nextInt();
                        System.out.print("Número do Apartamento: ");
                        int numeroApartamento = sc.nextInt();
                        System.out.print("Vaga de Garagem: ");
                        int vagaGaragem = sc.nextInt();
                        System.out.print("Sacada (true/false): ");
                        boolean sacada = sc.nextBoolean();
                        imovel = new Apartamento(cidade, bairro, localizacao, tamanho, area,
                                valorAluguel, condominio, valorCompra, anoConstrucao,
                                qtdQuartos, qtdBanheiros, mobiliado,
                                andar, numeroApartamento, vagaGaragem, sacada);
                        break;
                    case 2:
                        // Casa
                        System.out.print("Piscina (true/false): ");
                        boolean piscina = sc.nextBoolean();
                        System.out.print("Garagem (true/false): ");
                        boolean garagem = sc.nextBoolean();
                        System.out.print("Quintal (true/false): ");
                        boolean quintal = sc.nextBoolean();
                        imovel = new Casa(cidade, bairro, localizacao, tamanho, area,
                                valorAluguel, condominio, valorCompra,
                                anoConstrucao, qtdQuartos, qtdBanheiros,
                                mobiliado, piscina, garagem, quintal);
                        break;
                    case 3:
                        // Pavilhão
                        System.out.print("Capacidade de Carga: ");
                        double capacidadeCarga = sc.nextDouble();
                        System.out.print("Altura do Teto: ");
                        double alturaTeto = sc.nextDouble();
                        System.out.print("Área de Manobra (true/false): ");
                        boolean areaManobra = sc.nextBoolean();
                        imovel = new Pavilhao(cidade, bairro, localizacao, tamanho, area,
                                valorAluguel, condominio, valorCompra,
                                anoConstrucao, qtdQuartos, qtdBanheiros,
                                mobiliado, capacidadeCarga, alturaTeto, areaManobra);
                        break;
                    case 4:
                        // Comercial
                        System.out.print("Número de Salas: ");
                        int numeroSalas = sc.nextInt();
                        System.out.print("Espaço para Estacionamento (true/false): ");
                        boolean espacoEstacionamento = sc.nextBoolean();
                        System.out.print("Tipo de Comércio: ");
                        String tipoComercio = sc.next();
                        imovel = new Comercial(cidade, bairro, localizacao, tamanho, area,
                                valorAluguel, condominio, valorCompra,
                                anoConstrucao, qtdQuartos, qtdBanheiros,
                                mobiliado, numeroSalas, espacoEstacionamento, tipoComercio);
                        break;
                    default:
                        System.out.println("Opção inválida. Por favor, escolha novamente.");
                        valorEscolhido = 0;
                        continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, digite um número válido.");
                sc.nextLine();
                valorEscolhido = 0;
            }
        }

        System.out.println("Imóvel adicionado");
        imoveis.add(imovel);
        todosImoveis.add(imovel);
        System.out.println("");
    }

    public void listarImoveis() {
        if (imoveis.isEmpty()) {
            System.out.println("Nenhum imóvel cadastrado.");
            return;
        }
        System.out.println("Lista de Imóveis:");
        for (Imovel imovel : imoveis) {
            imovel.getDadosImovel();
            System.out.println("--------------------------");
        }
    }

    public boolean deletarImovel(Imovel imovel) {
        if (imoveis.remove(imovel)) {
            System.out.println("Imóvel removido");
            return true;
        } else {
            System.out.println("Imóvel não encontrado");
            return false;
        }
    }

    public void editarImovel(Imovel imovel) {
        System.out.println("Digite os novos valores (aperte ENTER para não alterar):");

        System.out.print("Cidade (" + imovel.getCidade() + "): ");
        String cidade = sc.nextLine();
        if (!cidade.isEmpty()) {
            imovel.setCidade(cidade);
        }

        System.out.print("Bairro (" + imovel.getBairro() + "): ");
        String bairro = sc.nextLine();
        if (!bairro.isEmpty()) {
            imovel.setBairro(bairro);
        }

        System.out.print("Localização (" + imovel.getLocalizacao() + "): ");
        String localizacao = sc.nextLine();
        if (!localizacao.isEmpty()) {
            imovel.setLocalizacao(localizacao);
        }

        System.out.print("Tamanho (" + imovel.getTamanho() + "): ");
        String tamanhoInput = sc.nextLine();
        if (!tamanhoInput.isEmpty()) {
            imovel.setTamanho(Double.parseDouble(tamanhoInput));
        }

        System.out.print("Área (" + imovel.getArea() + "): ");
        String areaInput = sc.nextLine();
        if (!areaInput.isEmpty()) {
            imovel.setArea(Double.parseDouble(areaInput));
        }

        System.out.print("Valor Aluguel (" + imovel.getValorAluguel() + "): ");
        String valorAluguelInput = sc.nextLine();
        if (!valorAluguelInput.isEmpty()) {
            imovel.setValorAluguel(Double.parseDouble(valorAluguelInput));
        }

        System.out.print("Condomínio (" + imovel.getCondominio() + "): ");
        String condominioInput = sc.nextLine();
        if (!condominioInput.isEmpty()) {
            imovel.setCondominio(Double.parseDouble(condominioInput));
        }

        System.out.print("Valor Compra (" + imovel.getValorCompra() + "): ");
        String valorCompraInput = sc.nextLine();
        if (!valorCompraInput.isEmpty()) {
            imovel.setValorCompra(Double.parseDouble(valorCompraInput));
        }

        System.out.print("Ano Construção (" + imovel.getAnoConstrucao() + "): ");
        String anoConstrucaoInput = sc.nextLine();
        if (!anoConstrucaoInput.isEmpty()) {
            imovel.setAnoConstrucao(Integer.parseInt(anoConstrucaoInput));
        }

        System.out.print("Quantidade de Quartos (" + imovel.getQtdQuartos() + "): ");
        String qtdQuartosInput = sc.nextLine();
        if (!qtdQuartosInput.isEmpty()) {
            imovel.setQtdQuartos(Integer.parseInt(qtdQuartosInput));
        }

        System.out.print("Quantidade de Banheiros (" + imovel.getQtdBanheiros() + "): ");
        String qtdBanheirosInput = sc.nextLine();
        if (!qtdBanheirosInput.isEmpty()) {
            imovel.setQtdBanheiros(Integer.parseInt(qtdBanheirosInput));
        }

        System.out.print("Mobiliado (atual: " + (imovel.getMobiliado() ? "Sim" : "Não") + ") (digite true ou false): ");
        String mobiliadoInput = sc.nextLine();
        if (!mobiliadoInput.isEmpty()) {
            imovel.setMobiliado(Boolean.parseBoolean(mobiliadoInput));
        }

        // Verificando o tipo do imóvel e editando atributos específicos
        if (imovel instanceof Apartamento) {
            Apartamento apt = (Apartamento) imovel;
            System.out.print("Andar (" + apt.getAndar() + "): ");
            String andarInput = sc.nextLine();
            if (!andarInput.isEmpty()) {
                apt.setAndar(Integer.parseInt(andarInput));
            }

            System.out.print("Número do Apartamento (" + apt.getNumeroApartamento() + "): ");
            String numeroApartamentoInput = sc.nextLine();
            if (!numeroApartamentoInput.isEmpty()) {
                apt.setNumeroApartamento(Integer.parseInt(numeroApartamentoInput));
            }

            System.out.print("Vaga de Garagem (" + apt.isVagaGaragem() + "): ");
            String vagaGaragemInput = sc.nextLine();
            if (!vagaGaragemInput.isEmpty()) {
                apt.setVagaGaragem(Integer.parseInt(vagaGaragemInput));
            }

            System.out.print("Sacada (atual: " + (apt.isSacada() ? "Sim" : "Não") + ") (digite true ou false): ");
            String sacadaInput = sc.nextLine();
            if (!sacadaInput.isEmpty()) {
                apt.setSacada(Boolean.parseBoolean(sacadaInput));
            }
        } else if (imovel instanceof Casa) {
            Casa casa = (Casa) imovel;
            System.out.print("Piscina (atual: " + (casa.getPiscina() ? "Sim" : "Não") + ") (digite true ou false): ");
            String piscinaInput = sc.nextLine();
            if (!piscinaInput.isEmpty()) {
                casa.setPiscina(Boolean.parseBoolean(piscinaInput));
            }

            System.out.print("Garagem (atual: " + (casa.getGaragem() ? "Sim" : "Não") + ") (digite true ou false): ");
            String garagemInput = sc.nextLine();
            if (!garagemInput.isEmpty()) {
                casa.setGaragem(Boolean.parseBoolean(garagemInput));
            }

            System.out.print("Quintal (atual: " + (casa.getQuintal() ? "Sim" : "Não") + ") (digite true ou false): ");
            String quintalInput = sc.nextLine();
            if (!quintalInput.isEmpty()) {
                casa.setQuintal(Boolean.parseBoolean(quintalInput));
            }
        } else if (imovel instanceof Pavilhao) {
            Pavilhao pavilhao = (Pavilhao) imovel;
            System.out.print("Capacidade de Carga (" + pavilhao.getCapacidadeCarga() + "): ");
            String capacidadeCargaInput = sc.nextLine();
            if (!capacidadeCargaInput.isEmpty()) {
                pavilhao.setCapacidadeCarga(Double.parseDouble(capacidadeCargaInput));
            }

            System.out.print("Altura do Teto (" + pavilhao.getAlturaTeto() + "): ");
            String alturaTetoInput = sc.nextLine();
            if (!alturaTetoInput.isEmpty()) {
                pavilhao.setAlturaTeto(Double.parseDouble(alturaTetoInput));
            }

            System.out.print("Área de Manobra (atual: " + (pavilhao.isAreaManobra() ? "Sim" : "Não")
                    + ") (digite true ou false): ");
            String areaManobraInput = sc.nextLine();
            if (!areaManobraInput.isEmpty()) {
                pavilhao.setAreaManobra(Boolean.parseBoolean(areaManobraInput));
            }
        } else if (imovel instanceof Comercial) {
            Comercial comercial = (Comercial) imovel;
            System.out.print("Número de Salas (" + comercial.getNumeroSalas() + "): ");
            String numeroSalasInput = sc.nextLine();
            if (!numeroSalasInput.isEmpty()) {
                comercial.setNumeroSalas(Integer.parseInt(numeroSalasInput));
            }

            System.out.print("Espaço para Estacionamento (atual: "
                    + (comercial.isEspacoEstacionamento() ? "Sim" : "Não") + ") (digite true ou false): ");
            String espacoEstacionamentoInput = sc.nextLine();
            if (!espacoEstacionamentoInput.isEmpty()) {
                comercial.setEspacoEstacionamento(Boolean.parseBoolean(espacoEstacionamentoInput));
            }

            System.out.print("Tipo de Comércio (" + comercial.getTipoComercio() + "): ");
            String tipoComercioInput = sc.nextLine();
            if (!tipoComercioInput.isEmpty()) {
                comercial.setTipoComercio(tipoComercioInput);
            }
        }
    }
}
